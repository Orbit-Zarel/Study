-- 这份示例脚本用于帮助你理解最基础的 SQL 操作。
-- 你可以直接用 sqlite3 执行它，然后观察每一步输出结果。

-- 为了方便重复执行，我们先删除旧表。
DROP TABLE IF EXISTS tasks;
DROP TABLE IF EXISTS users;

-- --------------------------------------------------
-- 1. 创建 users 表
-- --------------------------------------------------
CREATE TABLE users (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    username TEXT NOT NULL UNIQUE,
    role TEXT NOT NULL
);

-- --------------------------------------------------
-- 2. 创建 tasks 表
-- --------------------------------------------------
CREATE TABLE tasks (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    user_id INTEGER NOT NULL,
    title TEXT NOT NULL,
    status TEXT NOT NULL,
    priority INTEGER NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- 插入用户数据
INSERT INTO users (username, role) VALUES ('alice', 'user');
INSERT INTO users (username, role) VALUES ('bob', 'admin');
INSERT INTO users (username, role) VALUES ('charlie', 'user');

-- 插入任务数据
INSERT INTO tasks (user_id, title, status, priority)
VALUES (1, '学习 Java 基础', 'DONE', 1);

INSERT INTO tasks (user_id, title, status, priority)
VALUES (1, '学习 SQL 基础', 'RUNNING', 2);

INSERT INTO tasks (user_id, title, status, priority)
VALUES (2, '设计 LLM 网关接口', 'PENDING', 3);

INSERT INTO tasks (user_id, title, status, priority)
VALUES (3, '整理学习笔记', 'DONE', 1);

-- 打开列模式和标题显示，方便阅读输出
.mode column
.headers on

SELECT '查看 users 表中的全部数据' AS step;
SELECT * FROM users;

SELECT '查看 tasks 表中的全部数据' AS step;
SELECT * FROM tasks;

SELECT '只查询状态为 DONE 的任务' AS step;
SELECT * FROM tasks
WHERE status = 'DONE';

SELECT '按优先级从高到低排序' AS step;
SELECT * FROM tasks
ORDER BY priority DESC;

SELECT '只看前 2 条任务' AS step;
SELECT * FROM tasks
LIMIT 2;

SELECT '统计任务总数' AS step;
SELECT COUNT(*) AS total_task_count
FROM tasks;

SELECT '按状态分组统计任务数量' AS step;
SELECT status, COUNT(*) AS task_count
FROM tasks
GROUP BY status;

SELECT '查看每个任务属于哪个用户（简单连接查询）' AS step;
SELECT
    tasks.id,
    tasks.title,
    tasks.status,
    users.username
FROM tasks
JOIN users ON tasks.user_id = users.id;

SELECT '把标题为 学习 SQL 基础 的任务更新为 DONE' AS step;
UPDATE tasks
SET status = 'DONE'
WHERE title = '学习 SQL 基础';

SELECT * FROM tasks;

SELECT '删除标题为 整理学习笔记 的任务' AS step;
DELETE FROM tasks
WHERE title = '整理学习笔记';

SELECT * FROM tasks;
