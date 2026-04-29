# 33 AI 聊天前端基础 Vue

这一模块开始补一条“够用就好”的前端支线：

- Vue 聊天前端

目标不是把你带到完整前端主线，而是补：

- AI 应用常见前端形态

## 1. 为什么现在补前端

因为到这一步，你后端和 Agent 主线已经比较完整。

接下来最自然的就是理解：

- 一个 AI 应用最终怎么和用户交互

JD 里前端占比不大，所以这一节只补最小闭环。

## 2. AI 聊天前端最小需要什么

先抓住这些：

1. 输入框
2. 消息列表
3. 流式输出
4. Markdown 渲染
5. 会话历史

## 3. 为什么流式输出重要

因为很多 AI 回答较长。

如果必须等全部生成完再显示，体验会比较差。

所以聊天前端常见做法是：

- 后端流式返回
- 前端逐步追加内容

## 4. 为什么 Markdown 渲染常见

因为模型回答经常包含：

- 标题
- 列表
- 代码块
- 表格

如果不做 Markdown 渲染，可读性会差很多。

## 5. 和普通后台页面的区别

AI 聊天前端更强调：

- 对话感
- 流式感
- 历史上下文
- 结果可读性

## 6. 当前阶段最该先掌握什么

先抓住这几个：

1. AI 前端重点不是复杂组件
2. 消息列表和流式输出是核心
3. Markdown 渲染很常见
4. 会话历史要和后端状态配合

## 7. 市面上的流式输出通常怎么实现

当前主流通常是 3 类：

### 1. SSE

最常见。

特点：

- 单向推送
- 实现简单
- 很适合聊天回答流式返回

典型思路是：

- 后端持续返回 `text/event-stream`
- 前端一边读，一边把 chunk 追加到当前 assistant 消息

### 2. WebSocket

更适合双向实时交互更强的场景。

例如：

- 实时中断
- 多状态通知
- 更复杂的会话控制

### 3. `fetch` + `ReadableStream`

这是现在前端里很常见的一种做法。

特点：

- 不一定显式用 SSE
- 前端直接读取响应流
- 自己控制 chunk 解析和拼接

## 8. 前端如何显示流式内容

最常见的做法是：

1. 先创建一条 assistant 占位消息
2. 流式读取 chunk
3. 每来一个 chunk，就追加到当前消息的 `content`
4. 触发界面重新渲染

所以流式聊天前端的核心不是复杂组件，而是：

- 维护一条“正在生成”的消息

## 9. 市面上的 Markdown 渲染通常怎么实现

大多数项目不会自己手写 Markdown 解析器。

更常见的是直接用现成库。

### Vue 里常见

- `markdown-it`
- `marked`
- `highlight.js`
- `DOMPurify`

### React 里常见

- `react-markdown`
- `remark-gfm`
- `rehype-highlight`
- `Prism`

它们通常的职责分别是：

- Markdown 解析
- GFM 扩展
- 代码高亮
- HTML 清洗

## 10. 为什么流式输出和 Markdown 一起做会有坑

因为 Markdown 不是天然为“半截文本”设计的。

流到一半时，可能出现：

- 代码块没闭合
- 表格没结束
- 列表不完整
- 行内标记不成对

这会导致：

- 渲染闪烁
- 代码块抖动
- HTML 结构临时不稳定

## 11. 常见处理策略

### 策略 1：边流边渲染 Markdown

做法：

- 每收到一个 chunk，就重新做一次 Markdown 渲染

优点：

- 实时感强

缺点：

- 遇到复杂 Markdown 容易抖动

### 策略 2：流式阶段先按纯文本显示，结束后再完整渲染

优点：

- 更稳

缺点：

- 流式阶段体验略弱

很多产品会取折中方案：

- 普通文本实时渲染
- 复杂代码块结束后再稳定处理

## 12. 为什么要做 HTML 清洗

如果模型返回的内容直接进 HTML 渲染链路，就要考虑安全问题。

常见风险是：

- XSS
- 非预期 HTML 注入

所以常见做法是：

- Markdown 转 HTML 后再做 sanitize
- 或者限制原始 HTML 能力

## 13. Vue 场景下最常见的组合

一个很常见的前端组合是：

- 流式：`fetch` + `ReadableStream`
- Markdown：`markdown-it`
- 代码高亮：`highlight.js`
- 清洗：`DOMPurify`

## 14. 你当前阶段最该先掌握什么

先抓住这几个：

1. 流式输出重点是持续更新当前 assistant 消息
2. Markdown 渲染通常依赖现成库
3. 代码高亮和 HTML 清洗通常是 Markdown 链路的一部分
4. 流式和 Markdown 结合时要考虑未闭合内容问题

## 15. 学完这一模块后你应该能做到

- 理解一个最小 AI 聊天前端长什么样
- 理解流式输出和消息状态更新
- 理解为什么 Markdown 渲染和会话历史重要
- 理解市面上常见的流式与 Markdown 技术实现
- 为后续做 demo 前端打基础

## 16. 对应示例

- `examples/chat_message_list_demo.py`
- `examples/streaming_render_demo.py`
- `examples/session_sidebar_demo.py`
- `examples/stream_sse_client_demo.js`
- `examples/markdown_render_demo.js`

## 17. 当前说明

这一模块先不直接写 Vue 项目代码，继续先做最小流程建模。
