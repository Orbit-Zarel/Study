# 06 SQL 基础入门

这一模块的目标不是一下子把数据库学得很深，而是先帮你建立最基础的数据库直觉。

你后面做 `Spring Boot + MySQL` 项目时，经常会遇到这些问题：

- 用户信息放在哪里
- 任务状态放在哪里
- 怎么查某个用户的任务列表
- 怎么统计一共有多少条任务

这些问题本质上都离不开 SQL。

## 1. 什么是数据库

数据库可以先理解为：

- 一个专门存放结构化数据的地方
- 它比普通文本文件更适合“查询、筛选、统计、更新”

例如后端项目里常见的数据：

- 用户
- 任务
- Prompt 模板
- 调用日志

## 2. 什么是表、行、列

你可以先把数据库表想成一个二维表格。

例如用户表：

| id | username | role  |
|----|----------|-------|
| 1  | alice    | user  |
| 2  | bob      | admin |

这里：

- 表：`users`
- 列：`id`、`username`、`role`
- 行：每一条具体记录

## 3. 什么是主键

主键可以先理解为“每一行数据的唯一标识”。

常见写法：

```sql
id INTEGER PRIMARY KEY
```

它的作用是：

- 唯一标识一条记录
- 方便更新、删除、关联查询

## 4. 最常见的 SQL 操作：CRUD

CRUD 是后端里非常常见的缩写：

- Create：创建数据
- Read：读取数据
- Update：更新数据
- Delete：删除数据

### 创建表

```sql
CREATE TABLE users (
    id INTEGER PRIMARY KEY,
    username TEXT NOT NULL,
    role TEXT NOT NULL
);
```

### 插入数据

```sql
INSERT INTO users (username, role)
VALUES ('alice', 'user');
```

### 查询数据

```sql
SELECT * FROM users;
```

### 更新数据

```sql
UPDATE users
SET role = 'admin'
WHERE username = 'alice';
```

### 删除数据

```sql
DELETE FROM users
WHERE username = 'alice';
```

## 5. `WHERE` 很重要

`WHERE` 用来筛选你真正关心的数据。

例如：

```sql
SELECT * FROM tasks
WHERE status = 'RUNNING';
```

可以理解为：

- 不是把整张表全拿出来
- 而是只拿“状态为 RUNNING 的任务”

## 6. 排序、限制条数、统计

### 排序

```sql
SELECT * FROM tasks
ORDER BY created_at DESC;
```

### 限制条数

```sql
SELECT * FROM tasks
LIMIT 5;
```

### 统计数量

```sql
SELECT COUNT(*) FROM tasks;
```

### 分组统计

```sql
SELECT status, COUNT(*)
FROM tasks
GROUP BY status;
```

这在后端开发里非常常见，比如：

- 各状态任务分别有多少条
- 每个用户提交了多少次请求

## 7. 先认识两个常见字段约束

### `NOT NULL`

表示这个字段不能为空。

### `UNIQUE`

表示这个字段不能重复。

例如：

```sql
username TEXT NOT NULL UNIQUE
```

这通常很适合用户名、邮箱、请求幂等键这类字段。

## 8. SQLite 和 MySQL 的关系

你后面主项目更可能用 MySQL，但现在用 SQLite 学 SQL 很合适，因为：

- 更轻量
- 不需要单独启动数据库服务
- 能先把 SQL 基础练明白

需要注意的是：

- 大部分基础 SQL 思路是相通的
- 具体数据类型和少量语法细节会有差异

## 9. 学完这一模块后你应该能做到

- 理解表、行、列、主键这些基本概念
- 看懂最基础的增删改查 SQL
- 能写简单的条件查询、排序、统计语句
- 知道后端项目为什么离不开数据库

## 对应示例

- `examples/sql_basics_demo.sql`

## 如何运行这个示例

在仓库根目录执行：

```powershell
sqlite3 learning/06-sql-basics/examples/demo.db < learning/06-sql-basics/examples/sql_basics_demo.sql
```

如果你想手动进入 SQLite：

```powershell
sqlite3 learning/06-sql-basics/examples/demo.db
```

进入后可以再执行：

```sql
.tables
SELECT * FROM users;
SELECT * FROM tasks;
```
