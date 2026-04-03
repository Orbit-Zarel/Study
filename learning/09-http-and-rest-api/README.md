# 09 HTTP 与 REST API 基础

这一模块非常重要，因为你后面做 Spring Boot 后端时，绝大多数工作都在和 HTTP 请求打交道。

你会不断遇到这些问题：

- 前端请求是怎么发到后端的
- `GET`、`POST`、`PUT`、`DELETE` 有什么区别
- 什么是 URL
- 什么是状态码
- 什么是 REST API

## 1. 什么是 HTTP

HTTP 可以先理解成：

- 浏览器、前端、客户端 和 后端服务之间沟通的一套规则

例如：

- 浏览器访问网页
- 前端调用登录接口
- 你的程序请求第三方 API

这些很多时候都在用 HTTP。

## 2. 一次 HTTP 请求大概包含什么

你可以先把它想成“一封发给后端的请求信”。

通常包括：

- 请求方法
- 请求地址（URL）
- 请求头（Headers）
- 请求体（Body，可选）

例如：

```text
POST /api/auth/login
Authorization: Bearer xxx
Content-Type: application/json
```

请求体可能是：

```json
{
  "username": "alice",
  "password": "123456"
}
```

## 3. 什么是响应

后端收到请求后，会返回响应。

响应通常包括：

- 状态码
- 响应头
- 响应体

例如：

```json
{
  "token": "abc.def.xyz"
}
```

## 4. 常见的 HTTP 方法

### `GET`

通常用于：

- 查询数据

例如：

- `GET /api/tasks`
- `GET /api/tasks/1`

### `POST`

通常用于：

- 创建数据
- 提交动作

例如：

- `POST /api/auth/login`
- `POST /api/tasks`

### `PUT`

通常用于：

- 更新整体资源

### `DELETE`

通常用于：

- 删除资源

## 5. 什么是 URL

URL 可以先理解成：

- 一个资源或接口的地址

例如：

- `/api/tasks`
- `/api/tasks/1`
- `/api/auth/login`

你后面设计接口时，本质上就是在设计：

- 哪个 URL 对应哪个功能

## 6. 什么是状态码

状态码是后端告诉客户端“这次请求结果如何”的一个简短数字。

### 常见状态码

- `200 OK`：请求成功
- `201 Created`：创建成功
- `400 Bad Request`：请求参数有问题
- `401 Unauthorized`：没有登录或 token 无效
- `403 Forbidden`：已登录，但没有权限
- `404 Not Found`：资源不存在
- `500 Internal Server Error`：服务端内部出错

## 7. 什么是 REST API

REST API 可以先粗略理解成：

- 用比较规范、统一的方式设计 HTTP 接口

它强调的直觉包括：

- 用 URL 表示资源
- 用 HTTP 方法表示操作

例如：

- `GET /api/tasks`：查询任务列表
- `GET /api/tasks/1`：查询 id 为 1 的任务
- `POST /api/tasks`：创建任务
- `DELETE /api/tasks/1`：删除任务

## 8. 为什么 REST 风格很常见

因为它有几个优点：

- 接口语义比较清楚
- 前后端协作更方便
- 更适合平台型后端
- 和 Spring Boot 这类框架配合自然

## 9. 请求头为什么重要

请求头常常放一些“附加信息”，例如：

- `Authorization`
- `Content-Type`
- `Accept`

在你后面的项目里，最常见的就是：

```text
Authorization: Bearer <JWT>
```

这表示客户端在告诉后端：

- “这是我的登录凭证，请验证我”

## 10. 请求体什么时候会出现

请求体一般出现在：

- `POST`
- `PUT`

例如登录请求会把用户名密码放在请求体里。

而 `GET` 请求通常更偏向“拿数据”，一般不依赖请求体。

## 11. 当前阶段你应该建立的接口直觉

看到一个接口时，你可以先问自己：

1. 这个接口的 URL 是什么
2. 它用的是哪种 HTTP 方法
3. 它是查数据还是改数据
4. 是否需要登录
5. 成功和失败分别可能返回什么状态码

## 12. 学完这一模块后你应该能做到

- 理解一次 HTTP 请求和响应的基本结构
- 区分常见 HTTP 方法
- 理解 REST API 的基本设计思路
- 看懂后端接口文档时不再陌生

## 对应示例

- `examples/HttpRequestResponseDemo.java`
- `examples/RestApiDesignDemo.java`
