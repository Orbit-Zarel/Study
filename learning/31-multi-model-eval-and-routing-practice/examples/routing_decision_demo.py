def decide_model(task_type: str, need_json: bool = False):
    if need_json:
        return "json-stable-model"
    if task_type == "tool_use":
        return "tool-capable-model"
    if task_type == "deep_analysis":
        return "reasoning-model"
    return "small-fast-model"


if __name__ == "__main__":
    print(decide_model("simple_qa"))
    print(decide_model("tool_use"))
    print(decide_model("deep_analysis"))
    print(decide_model("simple_qa", need_json=True))
