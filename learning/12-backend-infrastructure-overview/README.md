# 12 后端项目里的语言、框架、中间件与外部服务

这一模块的目标是把你当前学到的东西真正“摆到一张图里”。

很多初学者在这个阶段都会混淆：

- 哪些是编程语言
- 哪些是开发框架
- 哪些是数据库或中间件
- 哪些是项目要连接的外部服务

你现在开始问这个问题，其实是一个很好的信号，说明你已经开始从“学零散知识点”进入“理解系统结构”的阶段了。

## 1. 先给出最短版本

在你后面的 AI 平台后端项目里，大致会是这样：

- `Java`：编程语言
- `Spring Boot`：后端开发框架
- `MySQL`：关系型数据库
- `Redis`：缓存 / 键值存储中间件
- `Kafka`：消息队列 / 事件流中间件
- `OpenAI / 通义千问`：外部模型服务

也就是说：

- 你用 `Java + Spring Boot` 写后端程序
- 这个后端程序去连接并使用 `MySQL / Redis / Kafka / LLM API`

## 2. 一张最基础的关系图

你可以先把它想成这样：

```text
用户 / 前端
    |
    v
Spring Boot 后端应用（你写的项目）
    |
    +---- MySQL（存正式数据）
    |
    +---- Redis（存缓存、计数、限流状态）
    |
    +---- Kafka（异步任务消息）
    |
    +---- OpenAI / 通义千问（外部模型 API）
```

这个图里最关键的一点是：

- 你的项目是中心
- 其它组件大多是“外部依赖服务”

## 3. 什么是“外部服务”

外部服务可以先理解成：

- 不是写在你 Java 代码里的功能
- 而是独立运行在另一个进程里的系统

例如：

- MySQL 要单独安装、单独启动
- Redis 要单独安装、单独启动
- Kafka 要单独安装、单独启动

然后你的 Spring Boot 程序通过网络去连接它们。

## 4. 为什么 Redis 和 Kafka 不属于 Java 自带组件

因为它们本身就是独立的软件系统。

它们不是：

- Java 语言自带的东西
- Spring Boot 自动内置的东西

而是：

- 你的 Java 项目可以接入和使用的基础设施

就像：

- 你写 Python 程序也能连 Redis
- 你写 Go 程序也能连 Kafka
- 它们并不专属于 Java

## 5. Java 项目是如何使用这些外部系统的

大致流程通常是：

1. 先安装并启动外部系统
2. 在 Java 项目里引入对应客户端依赖
3. 配置连接地址、端口、用户名、密码
4. 在代码里调用客户端 API

例如：

- 连 MySQL：用 JDBC / JPA / MyBatis
- 连 Redis：用 Redis 客户端或 Spring Data Redis
- 连 Kafka：用 Kafka 客户端或 Spring Kafka

## 6. 你当前项目里这些组件分别做什么

### Java

你写业务代码的语言。

例如：

- 类
- 方法
- DTO
- Service

### Spring Boot

帮你快速搭后端服务的框架。

例如：

- 写接口
- 处理 HTTP 请求
- 组织项目结构
- 集成数据库和中间件

### MySQL

负责存正式业务数据。

例如：

- 用户表
- 任务表
- 结果表
- Prompt 表

### Redis

负责存“快但不一定是最终权威数据”的东西。

例如：

- 热点缓存
- 限流计数
- 临时状态

### Kafka

负责做异步任务消息传递。

例如：

- 用户提交任务后，把 `taskId` 发进 Kafka
- 后台消费者再异步处理

### OpenAI / 通义千问

这是项目外部的模型服务提供商。

你的系统通过 HTTP API 调它们，而不是自己本地就拥有这些模型能力。

## 7. 那这些东西“长什么样”

这是一个很实际的问题。

### MySQL

通常你会看到：

- 一个数据库服务进程
- 一个客户端工具
- 一些数据库文件

### Redis

通常你会看到：

- 一个 Redis 服务进程
- 一个命令行客户端，例如 `redis-cli`
- 有时也会配合 GUI 工具 `Redis Insight`

### Kafka

通常你会看到：

- Kafka 服务进程
- 一套命令行脚本
- Topic、Producer、Consumer 这些运行中的概念

## 8. 在 Windows 上，一般如何“看到并使用” Redis

根据 Redis 官方文档，当前 Redis Open Source 在 Windows 上的官方支持方式重点是：

- 通过 Docker 运行

你可以先把它理解成：

- 不是下载一个最传统的原生 Windows `redis-server.exe` 然后双击就完事
- 而更常见的是先装 Docker Desktop，再运行 Redis 容器

### 你可以看的官方入口

- Redis 安装总览
- Redis Open Source 安装说明
- Redis Downloads 页面
- Redis Insight 下载页

### 对你当前最友好的理解方式

如果你只是想“先亲眼看看 Redis 长什么样”，最常见的学习路径是：

1. 先安装 Docker Desktop
2. 再运行 Redis 容器
3. 再安装 `Redis Insight` 看图形界面

这样会比一开始折腾复杂的原生环境更容易。

## 9. 在 Windows 上，一般如何“看到并使用” Kafka

Kafka 官方提供的是下载包和 Docker 镜像。

根据 Kafka 官方 Quickstart：

- 本地运行 Kafka 需要 `Java 17+`
- 可以使用下载文件运行
- 也可以使用 Docker 镜像运行

如果你下载 Kafka 本体，你通常会拿到：

- 一个压缩包
- 解压后包含 `bin`、`config` 等目录
- 里面有启动脚本

对于学习来说，最常见的两条路线是：

### 路线 A：直接下载 Kafka 二进制包

适合你想看看 Kafka 目录结构、脚本长什么样。

### 路线 B：先装 Docker，再拉 Kafka 镜像

适合你想快速体验，不想先研究太多本地服务细节。

## 10. 当前对你最实用的下载建议

如果你的目标是“先看见它们、知道它们真的存在”，我建议按下面顺序：

1. 先不急着全装一遍
2. 先看官方下载页面，建立“这些确实是独立软件”的认知
3. 如果要先装一个，优先从 `Docker Desktop` 开始
4. 然后先体验 `Redis`
5. 再体验 `Kafka`

这是因为：

- Redis 更容易感知“缓存”的效果
- Kafka 的概念和启动流程相对更绕一点

## 11. 你现在可以去看的官方页面

### Redis

- Redis 下载总览：<https://redis.io/downloads>
- Redis Open Source 安装总览：<https://redis.io/docs/latest/operate/oss_and_stack/install/>
- Redis Open Source 安装说明：<https://redis.io/docs/latest/operate/oss_and_stack/install/install-stack/>
- Redis Insight：<https://redis.io/insight/>

### Kafka

- Kafka 官网：<https://kafka.apache.org/>
- Kafka 下载页：<https://kafka.apache.org/downloads.html>
- Kafka Quickstart：<https://kafka.apache.org/quickstart>

### Docker Desktop

- Docker Desktop for Windows 安装页：<https://docs.docker.com/desktop/setup/install/windows-install/>

## 12. 对你当前阶段最重要的结论

请先记住这几句：

1. `Redis` 和 `Kafka` 都不是 Java 自带组件。
2. 它们是独立的中间件 / 基础设施服务。
3. 你的 Java + Spring Boot 项目只是去连接和使用它们。
4. 在真实项目里，这些服务通常需要单独安装、单独启动、单独配置。
5. 你现在先学概念是完全合理的，等后面再搭真实环境也不迟。

## 13. 你下一步可以怎么做

你有两个很自然的选择：

### 选择 A：继续保持“先概念、后环境”

继续学习项目结构、状态机、任务中心这些内容。

### 选择 B：开始第一次真实接触外部中间件

优先安装：

1. Docker Desktop
2. Redis
3. Redis Insight

这样你会第一次真实看到：

- 一个中间件服务是怎么运行的
- 一个 GUI 工具是怎么连上它的
- 数据是如何被查看的

如果你愿意，下一步我可以继续帮你做两件事里的一个：

1. 补 `13-task-status-machine`，开始进入主项目核心概念
2. 单独写一份 “Windows 上先安装 Docker Desktop，再体验 Redis” 的实操文档
