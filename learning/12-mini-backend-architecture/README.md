# 12 Mini Backend Architecture

这一模块的目标是把你前面学过的内容真正拼成一个“小型后端项目骨架”。

到目前为止，你已经分别接触过这些知识：

- Java 基础
- SQL
- Spring Boot
- JWT
- HTTP / REST API
- Redis
- Kafka

如果这些知识点只是分开记，很容易变成“每个都知道一点，但不知道怎么组合成项目”。

所以这一节要解决的问题是：

- 一个后端项目最基本的结构是什么
- 各模块分别负责什么
- 一次请求会经过哪些层
- 为什么 Redis 和 Kafka 会出现在这个项目里

## 1. 先看一个最小项目目标

我们先假设你要做一个非常小的“AI 任务后端”。

它至少要支持：

- 用户登录
- 提交任务
- 查询任务
- 异步执行任务

这其实已经足够让你把前面学的很多知识串起来。

## 2. 一个小型后端项目大概长什么样

你可以先把它理解成下面这张结构图：

```text
客户端 / 前端
    |
    v
Controller 层
    |
    v
Service 层
    |
    +---- Repository / Mapper / Database
    |
    +---- Redis
    |
    +---- Kafka
    |
    +---- 外部 API（例如 LLM）
```

## 3. 各层分别负责什么

### Controller 层

负责：

- 接收 HTTP 请求
- 读取参数
- 调用 Service
- 返回响应

例如：

- `POST /api/auth/login`
- `POST /api/tasks`
- `GET /api/tasks/{id}`

### Service 层

负责：

- 真正的业务逻辑
- 任务创建
- 状态判断
- 是否走缓存
- 是否发 Kafka 消息

### Repository / Mapper 层

负责：

- 和数据库打交道
- 保存任务
- 查询任务
- 更新任务状态

## 4. Redis 在这个架构里的位置

Redis 通常不是“正式数据唯一来源”，而更像：

- 加速器
- 临时状态存储
- 限流辅助组件

例如在这个小项目里，Redis 可以做：

- 缓存热点任务查询
- 缓存某个用户的基础信息
- 做用户级限流计数

## 5. Kafka 在这个架构里的位置

Kafka 主要解决的是：

- 异步执行
- 任务解耦

例如：

1. 用户调用 `POST /api/tasks`
2. 后端先把任务存数据库
3. 然后把 `taskId` 发到 Kafka
4. Consumer 再异步处理任务

所以 Kafka 更多是：

- 连接“提交任务”和“执行任务”的桥梁

## 6. MySQL 在这个架构里的位置

MySQL 负责保存正式业务数据，例如：

- 用户信息
- 任务信息
- 任务结果
- Prompt 模板

可以先记一个很重要的直觉：

- MySQL 更偏“权威数据源”
- Redis 更偏“加速与临时状态”

## 7. JWT 在这个架构里的位置

JWT 主要用于：

- 登录后发放身份凭证
- 后续接口校验调用者身份

所以它通常出现在：

- 登录接口返回 token
- 受保护接口校验 token

例如：

- `POST /api/auth/login` 返回 JWT
- `GET /api/tasks/1` 访问时需要带 JWT

## 8. 一次“提交任务”请求会怎么流动

这是这一模块最重要的一部分。

你可以先把流程理解成这样：

1. 用户发起 `POST /api/tasks`
2. 请求头带上 JWT
3. Controller 接收到请求
4. Controller 调用 TaskService
5. TaskService 校验参数和用户身份
6. TaskService 把任务保存到 MySQL
7. TaskService 把任务消息发送到 Kafka
8. Controller 返回“任务已提交”
9. Consumer 异步消费 Kafka 消息
10. Consumer 执行任务并更新数据库状态
11. 用户之后调用 `GET /api/tasks/{id}` 查询状态
12. 查询时可以优先看 Redis 缓存，必要时回源 MySQL

## 9. 为什么这个结构比“全写在一个类里”更好

因为真实项目里事情很多：

- 登录
- 鉴权
- 参数校验
- 数据库操作
- 缓存
- 消息发送
- 外部 API 调用

如果全塞进一个类或一个方法里，会非常难维护。

分层之后的好处是：

- 职责更清楚
- 更容易调试
- 更容易加新功能
- 更容易测试

## 10. 当前阶段你应该重点理解哪些设计思想

### 分层

表示：

- 不同代码放在不同责任区域里

### 解耦

表示：

- 提交任务和执行任务不要强耦合

### 单一职责

表示：

- 每一层尽量只做自己该做的事

### 可扩展

表示：

- 后面想接 Redis、Kafka、LLM、限流时，不至于推倒重来

## 11. 一个最小目录结构示意

```text
mini-backend
├── controller
│   ├── AuthController
│   └── TaskController
├── service
│   ├── AuthService
│   └── TaskService
├── repository
│   └── TaskRepository
├── dto
│   ├── LoginRequest
│   └── TaskResponse
├── security
│   └── JwtUtil
├── cache
│   └── TaskCacheService
├── mq
│   ├── TaskProducer
│   └── TaskConsumer
└── external
    └── LlmClient
```

当前阶段你不用记住每个名字，只要看懂：

- 它们是在按职责拆分项目

## 12. 这个骨架和你的主项目规划怎么对应

你后面的主项目其实就是这个小型后端骨架的增强版：

- `AuthController` -> 登录与鉴权
- `TaskController` -> 提交任务、查询任务
- `TaskService` -> 任务业务逻辑
- `Redis` -> 缓存和限流
- `Kafka` -> 异步执行
- `LlmClient` -> 调 OpenAI / 通义千问

所以你现在不是在学一个“虚构的小项目”，而是在提前看你主项目的缩略版。

## 13. 学完这一模块后你应该能做到

- 能把前面多个知识点拼成一个项目结构图
- 理解 Controller / Service / DB / Redis / Kafka 的关系
- 理解一次任务请求是怎么流经系统的
- 能开始从“项目视角”而不是“单个知识点视角”去看后端

## 对应示例

- `examples/MiniBackendLayersDemo.java`
- `examples/TaskRequestFlowDemo.java`
