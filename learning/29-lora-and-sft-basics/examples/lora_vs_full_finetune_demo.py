comparison = {
    "full_finetune": {
        "cost": "high",
        "resource_need": "high",
        "scope": "update whole model",
    },
    "lora": {
        "cost": "lower",
        "resource_need": "lower",
        "scope": "train small additional parameters",
    },
}


def show_comparison():
    print("LoRA vs Full Fine-Tune:")
    for key, value in comparison.items():
        print(f"{key}: {value}")


if __name__ == "__main__":
    show_comparison()
