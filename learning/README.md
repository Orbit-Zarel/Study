# 学习入口

这个目录用来承载后续的分模块学习材料。目标不是一次性把所有知识塞满，而是按照“先理解概念，再跑最小示例，最后回到主项目”的节奏推进。

## 当前建议学习顺序

1. `01-java-basics`
2. `02-java-oop`
3. `03-java-collections`
4. `04-java-exceptions`
5. `05-java-file-io`
6. `06-sql-basics`
7. `07-spring-boot-basics`
8. `08-jwt-and-auth`
9. `09-http-and-rest-api`
10. `10-redis-basics`
11. `11-kafka-basics`
12. `12-backend-infrastructure-overview`
13. `12-mini-backend-architecture`
14. `13-task-status-machine`
15. `14-idempotency-and-request-id`
16. `15-llm-gateway-basics`
17. `16-timeout-retry-and-fallback`
18. `17-rate-limit-and-circuit-breaker`
19. `18-observability-and-audit-logging`
20. `19-java-concurrency-and-thread-pool`
21. `20-agent-engineering-patterns`
22. `21-langgraph-basics`
23. `22-langchain-basics`
24. `23-rag-basics`
25. `24-vector-db-and-hybrid-search`
26. `25-rerank-and-ragas`
27. `26-mcp-and-a2a-advanced`
28. `27-prompt-engineering-and-model-routing`
29. `28-docker-and-ai-service-deployment`
30. `29-lora-and-sft-basics`
31. `30-llm-app-backend-integration`
32. `31-multi-model-eval-and-routing-practice`
33. `32-observability-and-production-guardrails`
34. `33-ai-chat-frontend-basics-vue`

## 你可以怎么使用这些材料

1. 先阅读模块下的 `README.md`，建立最基础的概念框架。
2. 再进入 `examples` 目录，运行示例代码，观察输出结果。
3. 看不懂的地方，直接和我讨论某一段代码或某一个概念。
4. 当基础更稳后，我们再继续补 `Spring Boot`、`SQL`、`JWT`、`Kafka` 等模块。

## Java 示例如何运行

在仓库根目录下执行：

```powershell
javac learning/01-java-basics/examples/HelloJava.java
java -cp learning/01-java-basics/examples HelloJava
```

如果示例文件名不同，只需要把命令中的路径和类名替换掉即可。

## 当前模块说明

- `01-java-basics`：Java 最基础语法、变量、类型、流程控制、方法
- `02-java-oop`：类、对象、封装、构造方法、`this`
- `03-java-collections`：数组、`List`、`Map`、遍历、简单统计

## 新增阶段说明

- `17-rate-limit-and-circuit-breaker`：限流、熔断、系统自我保护
- `18-observability-and-audit-logging`：结构化日志、traceId、审计与排障
- `19-java-concurrency-and-thread-pool`：线程池、异步执行、任务调度基础
- `20-agent-engineering-patterns`：单 Agent、多 Agent、规划执行汇总、工具保护、结构化输出
- `21-langgraph-basics`：节点、边、状态、条件分支、人工审核流转
- `22-langchain-basics`：prompt、tool、retriever、parser、chain 组件抽象
- `23-rag-basics`：RAG、chunking、embedding、top-k、检索增强生成闭环
- `24-vector-db-and-hybrid-search`：向量库、Faiss、Milvus、BM25、hybrid search、metadata filter
- `25-rerank-and-ragas`：rerank、RAG 评测、RAGAS、召回与精排分工
- `26-mcp-and-a2a-advanced`：MCP、tool schema、server/client、A2A、多 Agent 协作
- `27-prompt-engineering-and-model-routing`：prompt 分层、工具调用规则、模型路由、fallback
- `28-docker-and-ai-service-deployment`：Docker、镜像、容器、环境变量、健康检查、AI 服务部署
- `29-lora-and-sft-basics`：SFT、LoRA、微调边界、RAG 与微调区别
- `30-llm-app-backend-integration`：FastAPI、Agent、RAG、MCP、统一响应、后端整合
- `31-multi-model-eval-and-routing-practice`：多模型评测、任务分桶、主模型与备模型选择
- `32-observability-and-production-guardrails`：结构化日志、token usage、限流、配额、生产护栏
- `33-ai-chat-frontend-basics-vue`：Vue 聊天前端、消息列表、流式输出、Markdown、会话历史
