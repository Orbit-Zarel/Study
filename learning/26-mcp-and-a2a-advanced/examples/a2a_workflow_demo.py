def planner_agent(question: str):
    print(f"[planner] 收到问题: {question}")
    return [
        {"agent": "research_agent", "task": "查文档资料"},
        {"agent": "db_agent", "task": "查数据库记录"},
    ]


def research_agent(task: str):
    print(f"[research_agent] 执行任务: {task}")
    return "返回文档检索摘要"


def db_agent(task: str):
    print(f"[db_agent] 执行任务: {task}")
    return "返回数据库查询摘要"


def writer_agent(doc_result: str, db_result: str):
    print("[writer_agent] 汇总多个 Agent 的结果")
    return f"最终回答 = {doc_result} + {db_result}"


def run_workflow():
    tasks = planner_agent("总结宁德时代近期业绩会重点")
    doc_result = research_agent(tasks[0]["task"])
    db_result = db_agent(tasks[1]["task"])
    final_answer = writer_agent(doc_result, db_result)
    print(final_answer)


if __name__ == "__main__":
    run_workflow()
