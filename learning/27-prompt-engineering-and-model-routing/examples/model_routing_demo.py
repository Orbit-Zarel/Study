def route_model(task_type: str):
    if task_type == "simple_qa":
        return "small-fast-model"
    if task_type == "tool_use":
        return "tool-capable-model"
    if task_type == "deep_analysis":
        return "large-reasoning-model"
    return "default-model"


def main():
    for task_type in ["simple_qa", "tool_use", "deep_analysis"]:
        model = route_model(task_type)
        print(f"task_type={task_type} -> model={model}")


if __name__ == "__main__":
    main()
