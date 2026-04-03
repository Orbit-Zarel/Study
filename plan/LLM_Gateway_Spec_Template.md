# LLM 网关（A1：内部平台）规格模板（Spec Template）

## 1. 背景与目标

### 1.1 背景

- 本项目定位为内部 `LLM API Gateway`：为团队/应用提供统一的模型调用入口。
- 目标不是“做一个 Demo”，而是做一个可以长期迭代的后端平台骨架。

### 1.2 目标（MVP）

- 统一鉴权：JWT（`Authorization: Bearer <token>`）。
- 统一调用：OpenAI + 通义千问两家供应商，使用同一套上层接口。
- 统一治理：超时、重试、限流、降级（fallback）、可观测（traceId/日志/耗时）。
- 统一审计与用量：记录每次调用的 `provider/model/tokens/latency/status/errorCode`，可按 user 聚合。

### 1.3 非目标（本阶段不做）

- RAG 知识库与向量检索。
- Agent 工作流编排（Orchestrator）。
- 多租户计费系统（可先做配额/用量统计）。

## 2. 术语表

- `provider`：模型供应商标识（`openai` / `qwen`）。
- `model`：具体模型名（例如 `gpt-4o-mini`、`qwen-max`）。
- `traceId`：请求链路追踪 ID（贯穿网关与异步任务）。
- `requestId`：幂等请求 ID（用于去重、避免重复扣费/重复执行）。

## 3. 用户故事（User Stories）

- 作为开发者，我希望用统一接口调用 OpenAI/通义千问，并能快速切换供应商。
- 作为平台方，我希望对不同用户设置配额与限流，并能追溯每次调用的成本与失败原因。
- 作为运维/排障人员，我希望只凭 `traceId` 就能定位一次失败请求的完整上下文（不泄露密钥/敏感内容）。

## 4. 需求范围（Scope）

### 4.1 功能需求

- **鉴权与授权**
  - 登录签发 JWT。
  - 除登录/注册外，所有 API 必须校验 JWT。
  - 角色最小集：`user/admin`（可选）。

- **统一 LLM 调用（同步）**
  - 提供 `POST /api/llm/generate`。
  - 请求支持：显式 `provider` 路由。
  - 可选：支持 fallback（主 provider 失败时切换备用 provider），并可追溯。

- **限流与配额**
  - 用户级限流：例如 `N req/min`。
  - 供应商级限流：保护 Key 配额（例如 `N req/min` / `N tokens/min`）。
  - 配额（最小版）：按用户统计 tokens 与请求数，后续可扩展为“超过阈值拒绝”。

- **可靠性与韧性**
  - 超时：服务端可配置（建议默认 `30s`，按场景调整）。
  - 重试：只对“可重试错误”重试（网络超时/部分 5xx），限制次数（建议 2 次）。
  - 失败分类：可重试 vs 不可重试。

- **审计与用量**
  - 记录：`userId/provider/model/tokens/latencyMs/status/errorCode/createdAt`。
  - 支持按 user 查询汇总（最小需求：接口或 SQL 都行）。

- **可观测与排障**
  - 结构化日志（JSON 或 key-value）。
  - 日志必须包含：`traceId`、`userId`、`provider`、`model`、`latencyMs`、`status`、`errorCode`。
  - 日志不得包含：原始 API Key；默认不打印完整 prompt（必要时脱敏/截断）。

### 4.2 非功能需求

- **安全**
  - API Key 仅从环境变量/配置中心读取，不写入仓库。
  - 对关键字段脱敏：Key、可能包含隐私的 prompt。

- **性能**
  - 目标：网关自身额外开销尽量小（例如 P95 增量 < 50ms，作为长期目标）。

## 5. API 规格（契约）

### 5.1 认证

#### `POST /api/auth/login`

- **Request**

```json
{
  "username": "string",
  "password": "string"
}
```

- **Response**

```json
{
  "token": "jwt_token",
  "tokenType": "Bearer",
  "expiresIn": 3600
}
```

### 5.2 统一 LLM 生成（同步）

#### `POST /api/llm/generate`

- **Headers**
  - `Authorization: Bearer <JWT>`
  - `X-Request-Id: <uuid>`（可选，但建议提供，用于幂等/审计）

- **Request（统一抽象）**

```json
{
  "provider": "openai",
  "model": "gpt-4o-mini",
  "messages": [
    {"role": "system", "content": "You are a helpful assistant."},
    {"role": "user", "content": "Explain Kafka idempotency."}
  ],
  "temperature": 0.2,
  "maxTokens": 512,
  "timeoutMs": 30000,
  "responseFormat": "text",
  "fallback": {
    "enabled": true,
    "provider": "qwen",
    "model": "qwen-max"
  }
}
```

- **Response（成功）**

```json
{
  "traceId": "string",
  "requestId": "string",
  "provider": "openai",
  "model": "gpt-4o-mini",
  "fallbackUsed": false,
  "latencyMs": 1234,
  "output": {
    "type": "text",
    "text": "..."
  },
  "usage": {
    "promptTokens": 100,
    "completionTokens": 50,
    "totalTokens": 150
  }
}
```

- **Response（失败）**

```json
{
  "traceId": "string",
  "requestId": "string",
  "error": {
    "code": "LLM_PROVIDER_TIMEOUT",
    "message": "Upstream timeout",
    "retryable": true,
    "provider": "openai"
  }
}
```

## 6. 错误码规范（建议）

- `AUTH_INVALID_TOKEN`：JWT 无效/过期（不可重试）
- `AUTH_FORBIDDEN`：无权限（不可重试）
- `RATE_LIMITED_USER`：用户限流（可重试，建议稍后）
- `RATE_LIMITED_PROVIDER`：供应商限流（可重试，建议稍后）
- `LLM_PROVIDER_TIMEOUT`：上游超时（可重试）
- `LLM_PROVIDER_5XX`：上游 5xx（可重试）
- `LLM_PROVIDER_4XX`：上游 4xx（通常不可重试，需要修正请求）
- `LLM_BAD_REQUEST`：网关侧校验失败（不可重试）
- `INTERNAL_ERROR`：网关内部错误（视情况可重试）

## 7. 限流/重试/降级策略（建议模板）

### 7.1 限流

- 用户级：按 `userId` + endpoint 维度限流。
- 供应商级：按 `provider` + `model` 限流。

### 7.2 重试

- 仅对 `timeout/5xx` 重试。
- 重试次数：2。
- 退避：固定 200ms 或指数退避（先不复杂）。

### 7.3 降级（fallback）

- 仅在“可重试错误”且 fallback enabled 时触发。
- `fallbackUsed` 必须记录到响应与审计日志。

## 8. 审计与用量统计（数据模型建议）

- 表：`llm_requests`
  - `id, trace_id, request_id, user_id`
  - `provider, model, fallback_used`
  - `prompt_tokens, completion_tokens, total_tokens`
  - `latency_ms, status, error_code`
  - `created_at`

- 汇总查询（最小需求）
  - `GET /api/usage/summary?from=...&to=...`（可选）
  - 或先用 SQL 报表也可以

## 9. 测试用例（最小集合）

- **鉴权**
  - 无 JWT 访问受保护接口 -> 401
  - JWT 过期 -> 401

- **供应商路由**
  - provider=openai -> 走 OpenAI
  - provider=qwen -> 走通义

- **超时与重试**
  - 模拟上游超时 -> 触发重试（次数正确）

- **限流**
  - 压测触发用户限流 -> 返回 `RATE_LIMITED_USER`

- **降级**
  - openai 超时且 fallback enabled -> 切换 qwen，并记录 fallbackUsed=true

- **用量统计**
  - 一次调用后，usage 表能查到对应 tokens 与 provider/model

## 10. 里程碑（建议）

- M1：JWT 登录 + 受保护接口（场景1）
- M2：统一 LLM generate + 双供应商最小跑通（场景2）
- M3：路由 + fallback（场景3）
- M4：限流 + 用量统计（场景4-5）
- M5：可观测完善（场景6）
- M6：异步任务（Kafka）作为平台扩展（场景7-8）
