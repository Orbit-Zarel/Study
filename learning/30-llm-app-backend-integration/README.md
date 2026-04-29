# 30 LLM 应用后端整合

这一模块开始补真正接近岗位交付形态的一层：

- 把前面学过的能力整合成一个小型 AI 后端

前面你已经学过：

- FastAPI
- Agent
- RAG
- MCP / A2A
- Prompt / model routing
- Docker

这一节要补的是：

- 这些能力在一个后端服务里如何组合

## 1. 什么叫“整合”

不是单独会某个点就够。

真实项目里更常见的是：

- 一个 HTTP 接口接请求
- 先做鉴权
- 再判断任务类型
- 选择模型或 Agent
- 需要时走 RAG / MCP
- 记录日志和审计
- 最后返回结果

这就是“LLM 应用后端整合”。

## 2. 一个最小 AI 后端通常有哪些层

先抓住这几个：

1. API 层
2. Service 层
3. LLM / Agent 层
4. Retrieval / Tool 层
5. Logging / Audit 层

## 3. API 层负责什么

API 层通常负责：

- 接收请求
- 做参数校验
- 做鉴权
- 调用 service
- 返回响应

这一层不应该塞太多业务逻辑。

## 4. Service 层负责什么

Service 层更像编排层。

它负责：

- 识别任务类型
- 决定是否走 RAG
- 决定是否需要工具
- 选择模型
- 统一错误处理

## 5. LLM 应用后端里的常见链路

你可以先记成：

```text
HTTP Request
  -> Auth
  -> Request Validation
  -> Task Classification
  -> Model / Agent Routing
  -> RAG / MCP / Tool Use
  -> Final Response
```

## 6. 为什么这一层很重要

因为很多学习型项目到这里会断开。

表现为：

- RAG 能单独跑
- Agent 能单独跑
- MCP 工具也能调

但没有形成一个完整服务。

岗位里真正有价值的是：

- 把这些组件做成一个能被其他系统调用的后端

## 7. 常见接口会有哪些

例如：

- `/api/chat`
- `/api/rag/query`
- `/api/agent/run`
- `/api/usage/summary`
- `/api/health`

当前阶段不需要全做，但要先理解这些接口在整体里的位置。

## 8. 为什么任务分类很关键

因为不是所有请求都该走同一条链路。

例如：

- 简单问答 -> 直接模型回答
- 文档问答 -> 走 RAG
- 数据问题 -> 调 MCP 工具
- 复杂分析 -> 走 Agent

所以后端整合层通常要先做一次路由判断。

## 9. 为什么统一响应结构很重要

因为调用方不希望面对很多杂乱结果格式。

更常见的是统一成类似：

- traceId
- requestId
- route
- model
- answer
- citations
- usage

这样接口更像平台能力，而不是脚本拼接。

## 10. 和前面模块的关系

这一节本质上是在把前面的知识往一个后端服务里收拢：

- `RAG` 负责知识增强
- `MCP` 负责工具接入
- `Prompt` 负责行为约束
- `Routing` 负责模型和链路选择
- `Docker` 负责部署

## 11. 当前阶段最该先掌握什么

先抓住这几个：

1. API 层和 Service 层职责不同
2. AI 后端的价值在于整合多个能力
3. 不同请求要走不同链路
4. 统一响应结构和日志结构很重要

## 12. 学完这一模块后你应该能做到

- 理解一个小型 LLM 后端的大致分层
- 理解 RAG / Agent / MCP 如何接入同一服务
- 理解为什么任务分类和路由判断是核心编排点
- 为后面做完整 demo 打基础

## 对应示例

- `examples/api_to_service_demo.py`
- `examples/task_routing_demo.py`
- `examples/unified_response_demo.py`

## 当前说明

这一模块继续用 Python 做最小流程建模。

