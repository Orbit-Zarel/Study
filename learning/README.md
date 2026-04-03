# 学习入口

这个目录用来承载后续的分模块学习材料。目标不是一次性把所有知识塞满，而是按照“先理解概念，再跑最小示例，最后回到主项目”的节奏推进。

## 当前建议学习顺序

1. `01-java-basics`
2. `02-java-oop`
3. `03-java-collections`

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

后续我们可以继续加：

- `04-java-exceptions`
- `05-java-file-io`
- `06-sql-basics`
- `07-spring-boot-basics`
- `08-jwt-and-auth`
- `09-redis-basics`
- `10-kafka-basics`
