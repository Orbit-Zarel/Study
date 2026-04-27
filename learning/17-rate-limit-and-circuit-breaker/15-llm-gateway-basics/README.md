# 15 LLM Gateway 基础

这一模块开始真正进入你主项目的核心能力之一：

- LLM Gateway

也就是：

- 统一接入不同大模型供应商
- 对上层业务提供一致接口
- 在中间做治理、审计、限流、重试等能力

这会是你后面主项目非常重要的一层。

## 1. 什么是 LLM Gateway

你可以先把它简单理解成：

- 一个位于“业务代码”和“大模型供应商”之间的中间层

例如：

- 你的业务服务不直接到处写 OpenAI API 调用
- 而是统一调用你自己的 LLM Gateway

然后由这个 Gateway 再决定：

- 走 OpenAI
- 还是走通义千问
- 用哪个模型
- 是否重试
- 是否降级

## 2. 为什么不直接在业务里调用 OpenAI

这是一个非常关键的问题。

如果业务代码里到处直接写供应商调用，会带来很多问题：

- 接口风格不统一
- 切换供应商时改动很多地方
- 很难统一做日志和审计
- 很难统一做限流和超时控制
- 很难统一统计 token 用量

所以更好的做法通常是：

- 在业务层和供应商之间加一层抽象

这层抽象就是 LLM Gateway。

## 3. 你可以先把 LLM Gateway 想成什么

当前阶段先把它理解成：

- “模型调用网关”
- “统一模型访问入口”
- “平台化治理层”

你后面的 AI 平台后端项目，之所以像个平台，而不只是一个普通小接口项目，很大程度上就是因为多了这层。

## 4. LLM Gateway 最基本在做什么

一个最小的 LLM Gateway，通常会做这些事情：

1. 接收上层请求
2. 识别要调用哪个 `provider`
3. 识别要调用哪个 `model`
4. 转换成供应商需要的请求格式
5. 调用供应商 API
6. 把结果统一整理后返回

## 5. 什么是统一抽象

这是 LLM Gateway 最核心的思想之一。

例如不同供应商接口可能都不完全一样，但你希望上层业务看到的是同一套格式。

例如统一输入：

- `provider`
- `model`
- `messages`
- `temperature`
- `maxTokens`

统一输出：

- `text`
- `usage`
- `provider`
- `model`
- `latencyMs`
- `requestId`

这样上层代码就不必关心每家供应商的细节差异。

## 6. 什么是 Provider

Provider 就是：

- 大模型供应商

例如：

- `openai`
- `qwen`

所以当你的接口里写：

```json
{
  "provider": "openai",
  "model": "gpt-4o-mini"
}
```

本质上就是在告诉 Gateway：

- 请走 OpenAI
- 请使用指定模型

## 7. 什么是 Model

Model 就是：

- 具体使用的模型名称

例如：

- `gpt-4o-mini`
- `qwen-max`

同一家供应商也可能有多个模型，所以：

- `provider` 决定“找谁”
- `model` 决定“用谁家的哪一个”

## 8. 一个最小调用流程

你可以先把它记成这样：

1. 用户调用你的 `POST /api/llm/generate`
2. 请求里传入 `provider`、`model`、`messages`
3. 你的 Gateway 根据 `provider` 选择供应商实现
4. Gateway 调用真实的大模型 API
5. Gateway 把响应统一整理后返回给调用方

## 9. 为什么这层和普通“转发”不一样

因为 Gateway 通常不只是“把请求转发出去”。

它还会承担很多平台能力：

- 鉴权
- 限流
- 超时控制
- 重试
- fallback
- 审计日志
- token 用量统计

所以它不只是一个代理层，更像：

- 一个模型访问治理中心

## 10. 什么是 fallback

fallback 可以先理解成：

- 主供应商失败时，尝试切到备用供应商

例如：

- 先走 OpenAI
- 如果超时或可重试失败，再切到通义千问

这会让系统更稳，但也需要注意：

- 是否真的允许自动切换
- 是否要记录 fallback 是否发生

## 11. 为什么 LLM Gateway 和你前面学的内容都有关

这部分会把前面的知识真正串起来：

### 和 JWT 有关

因为 Gateway 接口通常需要鉴权。

### 和 HTTP / REST API 有关

因为它通常会暴露统一接口，例如：

- `POST /api/llm/generate`

### 和 Redis 有关

因为你可能会做：

- 限流计数
- 某些缓存

### 和 Kafka 有关

因为后续你可能会把耗时模型调用变成异步任务。

### 和状态机、幂等有关

因为异步调用、重试、结果查询都会和这些概念连在一起。

## 12. 当前阶段你应该先理解哪些最重要的点

请先抓住这几个：

1. 上层业务不应该到处直接写供应商调用代码
2. LLM Gateway 的价值在于“统一入口 + 统一治理”
3. `provider` 和 `model` 是两层不同概念
4. Gateway 返回给上层的结果应该尽量统一

## 13. 学完这一模块后你应该能做到

- 理解为什么主项目要单独做一层 LLM Gateway
- 理解 Provider / Model / Gateway 的关系
- 看懂一个最基础的统一模型调用流程
- 为后续学习超时、重试、限流、fallback 做准备

## 对应示例

- `examples/LlmGatewayFlowDemo.java`
- `examples/ProviderRoutingDemo.java`
