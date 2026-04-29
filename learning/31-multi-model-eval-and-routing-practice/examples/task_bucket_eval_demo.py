task_buckets = {
    "simple_qa": "small-fast-model",
    "tool_use": "tool-capable-model",
    "structured_output": "json-stable-model",
    "deep_analysis": "reasoning-model",
}


if __name__ == "__main__":
    for task, model in task_buckets.items():
        print(f"{task} -> {model}")
