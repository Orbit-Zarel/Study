# 22 LangChain 基础

这一模块补的是 `LangGraph` 前面那一层更基础的东西：

- Agent 和 RAG 系统里常用的组件积木

你可以先把 `LangChain` 理解成：

- 帮你组织 prompt、模型、工具、检索器、输出解析器的一套组件层框架

## 1. LangChain 和 LangGraph 的关系

当前阶段先这样理解：

- `LangChain` 更偏组件层
- `LangGraph` 更偏工作流层

也就是：

- `LangChain` 解决“这一块怎么做”
- `LangGraph` 解决“这些块怎么连起来”

例如：

- prompt template
- model
- tool
- retriever
- output parser

这些都更像 `LangChain` 范围。

而：

- state
- node
- edge
- conditional branch

这些更像 `LangGraph` 范围。

## 2. 为什么要先学 LangChain

因为很多 Agent 系统不是一上来就需要图。

更常见的是先有这些问题：

- prompt 怎么复用
- 工具怎么封装
- 检索器怎么接进来
- 输出怎么稳定变成结构化数据
- 多个步骤怎么串成简单链路

这些问题如果没有组件层抽象，后面工作流也会很乱。

## 3. 什么是 Chain

Chain 可以先理解成：

- 把多个步骤按顺序串起来

例如：

```text
用户问题
  -> prompt template
  -> model
  -> output parser
```

这就是一个很小的链。

它适合：

- 输入输出比较稳定
- 步骤相对固定
- 不需要复杂分支

## 4. 什么是 Prompt Template

Prompt Template 可以先理解成：

- 带变量占位的 prompt 模板

例如：

```text
请总结公司 {companyName} 在 {quarter} 的业绩要点。
```

调用时再把变量填进去。

这样做的价值是：

- 避免到处拼字符串
- prompt 可复用
- 更容易统一维护

## 5. 什么是 Output Parser

Output Parser 可以先理解成：

- 把模型输出从自由文本转成更稳定结构

例如把回答解析成：

- JSON
- 列表
- 指定字段对象

这在你前面学过的结构化输出里已经有直觉了。

`LangChain` 只是把这类能力组件化了。

## 6. 什么是 Tool

Tool 可以先理解成：

- 提供给模型调用的外部能力封装

例如：

- 查数据库
- 调 HTTP API
- 算日期范围
- 读取文档

你前面做过 `MCP` 工具。

可以把 `LangChain Tool` 先理解成：

- 和 MCP 工具处于相近层次
- 只是接入方式和协议不完全一样

## 7. 什么是 Retriever

Retriever 可以先理解成：

- 从外部知识里帮你取回相关内容的组件

它通常不负责最终回答。

它负责的是：

- 根据问题找相关文档片段

这正是后面 `RAG` 的核心积木之一。

## 8. 什么是 Memory

Memory 可以先理解成：

- 帮系统保留一部分上下文状态

例如：

- 之前聊过什么
- 用户偏好是什么
- 已经查过哪些东西

但当前阶段要先记住一点：

- Memory 不是“把所有历史都无限追加”

真正工程里仍然要考虑：

- 截断
- 摘要
- 状态提取

## 9. 一个最小 LangChain 直觉

你可以先记成这样：

```text
input
  -> prompt template
  -> model
  -> parser
  -> output
```

如果再加工具：

```text
input
  -> agent
  -> tool
  -> model
  -> final answer
```

如果再加检索：

```text
input
  -> retriever
  -> retrieved docs
  -> prompt
  -> model
  -> output
```

## 10. LangChain 适合什么场景

比较适合：

- 组件拼装
- 简单顺序链路
- RAG 原型
- 工具调用原型
- 输出结构化

如果流程开始出现很多：

- 条件分支
- 回退
- 人工审核
- 多轮状态管理

通常就会更自然地过渡到 `LangGraph`。

## 11. 你现在最该建立的 LangChain 直觉

先抓住这几个：

1. 它不是“另一个模型”
2. 它主要提供的是组件抽象
3. prompt / tool / retriever / parser 是最重要的几块
4. RAG 往往就是在这些组件上拼起来的

## 12. LangChain 和你已有经验怎么对齐

你已经有这些经验：

- `MCP` 工具
- 结构化输出
- Agent Loop
- 多 Agent 原型

所以你学 LangChain 时，不要把它看成陌生体系。

更准确的看法是：

- 它是在帮你把这些已有思路组件化

## 13. 学完这一模块后你应该能做到

- 理解 `LangChain` 在 Agent 系统里的位置
- 能区分 `prompt template`、`tool`、`retriever`、`parser`
- 能把一个简单问题看成链式组件拼装
- 为下一节 `RAG` 做好准备

## 对应示例

- `examples/PromptTemplateDemo.java`
- `examples/ToolAndParserDemo.java`
- `examples/RetrieverChainDemo.java`

## 当前说明

这一模块仍然先用 Java 建模流程。

下一节开始进入 `RAG`，就会自然用到这里的：

- retriever
- prompt
- parser

