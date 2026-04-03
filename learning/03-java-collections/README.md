# 03 Java 集合入门

当前阶段你可以先把集合理解为：“帮你存放一批数据的工具”。

## 这一模块重点理解什么

- 数组适合什么场景
- `List` 是什么
- `Map` 是什么
- 如何遍历一组数据
- 为什么集合在后端开发里很常见

## 1. 数组

数组适合“长度固定”的数据。

```java
int[] scores = {90, 85, 70};
```

特点：

- 类型一致
- 长度固定
- 访问速度快

## 2. List

`List` 可以理解为“可变长度的有序列表”。

```java
List<String> names = new ArrayList<>();
names.add("Alice");
names.add("Bob");
```

特点：

- 顺序可保留
- 能按下标访问
- 长度可动态变化

## 3. Map

`Map` 可以理解为“键值对容器”。

```java
Map<String, Integer> scores = new HashMap<>();
scores.put("Alice", 95);
scores.put("Bob", 88);
```

特点：

- 按 key 查 value
- 适合做映射关系

## 4. 为什么后端常用集合

因为后端经常要处理：

- 一批用户
- 一批任务
- 一批订单
- 某个用户对应的一组属性

这些都离不开数组、`List`、`Map` 这类结构。

## 5. 学完这一模块后你应该能做到

- 看懂最常见的集合代码
- 自己创建 `List` 和 `Map`
- 会写最基础的遍历和统计

## 对应示例

- `examples/CollectionDemo.java`
