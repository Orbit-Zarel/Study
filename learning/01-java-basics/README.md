# 01 Java 基础语法

这个模块的目标很简单：把“看见 Java 代码不陌生、能自己写出最基础的程序”先找回来。

## 这一模块你需要先掌握什么

- Java 程序从 `main` 方法开始执行
- 变量是什么
- 常见基础类型有哪些
- `if`、`for`、`while` 分别在什么场景下使用
- 方法是什么，为什么要把代码拆成方法

## 1. Java 程序的最小结构

一个最基础的 Java 程序通常长这样：

```java
public class HelloJava {
    public static void main(String[] args) {
        System.out.println("Hello Java");
    }
}
```

可以先这样理解：

- `class`：类，Java 代码通常写在类里面
- `main`：程序入口
- `System.out.println(...)`：向控制台打印内容

## 2. 变量与基础类型

变量可以理解为“有名字的盒子”，用来保存数据。

常见类型：

- `int`：整数，例如 `18`
- `double`：小数，例如 `3.14`
- `boolean`：真假，例如 `true`
- `char`：单个字符，例如 `'A'`
- `String`：字符串，例如 `"hello"`

示例：

```java
int age = 20;
double score = 95.5;
boolean passed = true;
String name = "Alice";
```

## 3. 流程控制

### `if`

当你要“根据条件做不同事情”时，优先想到 `if`。

```java
if (score >= 60) {
    System.out.println("及格");
} else {
    System.out.println("不及格");
}
```

### `for`

当你“明确知道大概要重复多少次”时，优先想到 `for`。

```java
for (int i = 1; i <= 3; i++) {
    System.out.println(i);
}
```

### `while`

当你“只知道满足条件就继续，不确定具体重复几次”时，常用 `while`。

```java
int count = 0;
while (count < 3) {
    System.out.println(count);
    count++;
}
```

## 4. 方法

方法就是“给一段逻辑起名字”，以后需要时直接调用。

好处：

- 代码更清晰
- 减少重复
- 更方便测试和修改

```java
public static int add(int a, int b) {
    return a + b;
}
```

这段代码表示：

- 方法名叫 `add`
- 接收两个 `int`
- 返回一个 `int`

## 5. 学完这一模块后你应该能做到

- 看懂最基础的 Java 程序结构
- 自己写变量、分支、循环、方法
- 能运行简单示例并理解输出结果

## 对应示例

- `examples/HelloJava.java`
- `examples/ControlFlowDemo.java`
