evaluation = {
    "model_a": {"latency_ms": 900, "cost": "low", "json_success_rate": 0.82},
    "model_b": {"latency_ms": 1500, "cost": "medium", "json_success_rate": 0.93},
    "model_c": {"latency_ms": 2500, "cost": "high", "json_success_rate": 0.96},
}


if __name__ == "__main__":
    for model, result in evaluation.items():
        print(model, result)
