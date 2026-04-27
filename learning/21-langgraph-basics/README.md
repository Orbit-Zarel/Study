# 21 LangGraph 基础

这一模块开始把上一节的 Agent 工程模式，映射到更常见的 Python Agent 框架思路里。

你前一节已经理解了：

- 单 Agent
- Planner / Executor / Synthesizer
- Tool Guard
- Structured Output
- 中间结果落盘

这一节要理解的是：

- 如果把这些流程画成“图”，应该怎么组织

这就是 LangGraph 这类框架的核心思路。

## 1. 什么是 LangGraph

当前阶段先把 LangGraph 理解成：

- 用“状态 + 节点 + 边”来组织 Agent 流程的框架

也就是：

- 节点负责做一步事
- 边决定下一步去哪
- 状态负责在整个流程里传递数据

它适合处理：

- 多步骤 Agent
- 条件分支
- 重试与回退
- 人工介入

## 2. 为什么 Agent 需要“图”

因为简单 Agent 可以靠一个 loop 撑住。

但流程一复杂，就会出现：

- 先规划
- 再调用工具
- 如果失败就重试
- 如果结果不够再补查
- 最后汇总回答

这时如果只靠一大段 `if/else`，很快就会变乱。

图的价值是：

- 把流程结构显式画出来
- 每一步职责更清楚
- 更容易控制状态流转

## 3. 什么是节点

节点可以先理解成：

- 流程中的一个处理步骤

例如：

- `planner`
- `tool_executor`
- `synthesizer`
- `human_review`

一个节点通常做一件相对单一的事。

## 4. 什么是边

边可以先理解成：

- 从一个节点流向下一个节点的路径

例如：

- `planner -> executor`
- `executor -> synthesizer`
- `executor -> retry_handler`

如果节点是“做什么”，边就是“下一步去哪”。

## 5. 什么是状态

状态是 LangGraph 思路里最关键的部分之一。

你可以先把它理解成：

- 在整个流程中不断被更新的一份共享数据

例如状态里可能放：

- 用户问题
- 规划结果
- 工具结果
- 错误信息
- 最终回答

所以图不是节点彼此直接乱传参数，而是：

- 节点读取状态
- 节点更新状态
- 下一个节点继续读这个状态

## 6. 一个最小 LangGraph 直觉

你先记住这条链路：

```text
start
  -> planner
  -> executor
  -> synthesizer
  -> end
```

这已经很接近上一节的 `Planner-Executor-Synthesizer` 模式了。

区别只是：

- 上一节你是从工程模式理解
- 这一节你开始从图结构理解

## 7. 条件分支为什么重要

真实 Agent 流程不是每次都走同一条路。

例如：

- 规划成功 -> 继续执行
- 规划失败 -> 走 fallback
- 工具结果为空 -> 触发补查
- 风险问题 -> 转人工审核

这类逻辑在图里通常表现为：

- 一个节点出去有多条边

所以 LangGraph 适合做：

- 条件分支明确
- 状态变化明显
- 后续路径依赖前一步结果

的系统。

## 8. 重试节点和回退节点

你前面已经学过 timeout、retry、fallback。

在图里，这些通常会变成显式节点：

- `retry_handler`
- `fallback_handler`

好处是：

- 错误路径不再隐藏在一堆代码里
- 失败链路和成功链路一样可读

## 9. Human-in-the-Loop 怎么放进图里

如果某些任务不能全自动做完，就可以在图里加人工审核节点。

例如：

```text
executor
  -> human_review
  -> final_writer
```

这比在代码里随便塞一个“等待人工确认”更清楚。

## 10. LangGraph 和手写流水线的关系

你可以把 LangGraph 理解成：

- 把你手写的 Planner / Executor / Synthesizer 流程，变成显式的图结构

你之前已经接触过这些手写模式，所以学 LangGraph 会更快。

因为你不是从零开始理解：

- 为什么要拆节点
- 为什么要有状态
- 为什么要有条件分支

这些你前面已经有工程直觉了。

## 11. 什么场景适合 LangGraph

比较适合：

- 多步骤决策
- 多工具调用
- 多 Agent 协作
- 需要重试、回退、人工介入

不太适合：

- 只问一次就答一次的简单聊天
- 一个 prompt 就能完成的小任务

简单任务直接用单 Agent 往往更轻。

## 12. 当前阶段最重要的理解

先抓住这几个点：

1. LangGraph 的核心不是“更强模型”，而是“更清晰流程”
2. 节点负责处理，边负责流转，状态负责传值
3. 条件分支和失败路径应该显式建模
4. 它本质上是在管理 Agent 工作流

## 13. 学完这一模块后你应该能做到

- 能把一个 Agent 流程拆成节点、边、状态
- 能理解 LangGraph 为什么适合多步骤 Agent
- 能把 Planner / Executor / Synthesizer 映射成图结构
- 能理解重试、回退、人工审核在图里该怎么放

## 对应示例

- `examples/StateGraphDemo.java`
- `examples/ConditionalEdgeDemo.java`
- `examples/HumanReviewFlowDemo.java`

## 当前说明

这一模块先继续用 Java 模拟图结构。

下一步进入 Python 时，再把这些概念对应到真正的 `LangGraph` 代码写法。
