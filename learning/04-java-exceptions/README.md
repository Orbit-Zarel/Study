# 04 Java 异常处理

异常处理是后端开发里非常常见的一块内容。你可以先把它理解成：

- 程序运行时出现了“意料外情况”
- 如果我们不处理，程序可能直接中断
- 如果我们处理得好，就能让程序更稳定，也更容易排查问题

## 1. 什么是异常

比如下面这些情况都可能产生异常：

- 把字符串 `"abc"` 转成数字
- 访问数组不存在的下标
- 读取一个不存在的文件
- 调用某个对象的方法时，这个对象其实是 `null`

Java 用“异常对象”来表示这类错误。

## 2. 为什么需要异常处理

因为真实项目里，错误几乎一定会发生。

你不可能保证：

- 用户输入永远正确
- 文件永远存在
- 数据库永远连得上
- 第三方接口永远不超时

所以我们要学会：

- 识别可能出错的地方
- 用 `try-catch` 保护代码
- 在必要时给出合理提示

## 3. `try-catch` 的基本写法

```java
try {
    int value = Integer.parseInt("abc");
} catch (NumberFormatException e) {
    System.out.println("转换失败");
}
```

可以先这样理解：

- `try`：这里面放“可能出错”的代码
- `catch`：如果真的出错，就执行这里的处理逻辑
- `e`：异常对象，里面通常带着错误信息

## 4. `finally` 是什么

`finally` 里的代码，无论有没有异常，通常都会执行。

它常用于：

- 关闭文件
- 关闭数据库连接
- 做收尾日志

```java
try {
    System.out.println("执行中");
} catch (Exception e) {
    System.out.println("出现异常");
} finally {
    System.out.println("收尾操作");
}
```

## 5. 常见异常先认识几个

- `NumberFormatException`：字符串转数字失败
- `ArrayIndexOutOfBoundsException`：数组下标越界
- `NullPointerException`：空指针
- `IOException`：输入输出相关错误

## 6. 什么时候要主动抛出异常

有时候不是系统自己报错，而是我们发现“当前参数不合法”，这时可以主动抛异常：

```java
if (age < 0) {
    throw new IllegalArgumentException("年龄不能小于 0");
}
```

这表示：

- 这里的输入不符合规则
- 程序不应该继续悄悄执行下去

## 7. 学完这一模块后你应该能做到

- 看懂 `try-catch-finally`
- 理解“异常不是语法问题，而是运行时问题”
- 能处理最基础的转换错误、下标越界、参数不合法等问题

## 对应示例

- `examples/ExceptionDemo.java`
- `examples/ValidationDemo.java`
