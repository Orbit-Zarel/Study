# 32 可观测性与生产护栏

这一模块开始补“能上线”之前必须有的一层：

- 可观测性
- 生产护栏

前面你已经单独学过日志、限流、熔断、健康检查。

这一节要把这些放回生产系统视角里重新理解。

## 1. 什么是生产护栏

可以先理解成：

- 为了避免系统失控而加的一组保护机制

常见包括：

- rate limit
- timeout
- retry
- fallback
- circuit breaker
- quota
- permission filter

## 2. 为什么 LLM / Agent 系统尤其需要护栏

因为这类系统常见风险很多：

- 调用成本高
- 输出不稳定
- 工具可能误用
- 上游模型可能超时
- 用户问题长度可能失控

## 3. 可观测性到底要看什么

先抓这几个：

- traceId
- requestId
- model
- route
- tool calls
- latency
- error code
- token usage

## 4. 为什么只打普通日志不够

因为你需要回答这些问题：

- 这次请求走了哪条链路
- 用了哪个模型
- 调了哪些工具
- 哪一步失败
- 为什么 token 突然暴涨

所以日志必须更结构化。

## 5. 常见生产护栏有哪些

### 输入护栏

- 输入长度限制
- 文件大小限制
- 参数校验

### 调用护栏

- timeout
- retry
- fallback
- circuit breaker

### 成本护栏

- token 配额
- 用户额度
- 模型白名单

### 工具护栏

- 工具白名单
- 参数校验
- 输出脱敏

## 6. 为什么 token usage 监控很重要

因为 AI 系统很多问题最后会表现成：

- 成本异常
- 请求变慢
- 上下文膨胀

这些都和 token usage 强相关。

## 7. 当前阶段最该先掌握什么

先抓住这几个：

1. 可观测性不是附属功能
2. 护栏是平台稳定性的核心部分
3. 结构化日志和 token usage 监控很重要
4. 输入、调用、成本、工具四类护栏都要考虑

## 8. 学完这一模块后你应该能做到

- 理解生产护栏的基本组成
- 理解为什么 Agent 系统必须做结构化观测
- 理解 token usage 和成本稳定性的关系
- 为后续做生产化 demo 打基础

## 对应示例

- `examples/structured_log_demo.py`
- `examples/guardrail_check_demo.py`
- `examples/token_usage_monitor_demo.py`

## 当前说明

这一模块继续用 Python 做最小流程建模。

