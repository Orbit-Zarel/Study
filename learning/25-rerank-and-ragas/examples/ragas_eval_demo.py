evaluation_result = {
    "faithfulness": 0.81,
    "answer_relevancy": 0.87,
    "context_precision": 0.76,
    "context_recall": 0.79,
}


def print_ragas_result():
    print("一个最小 RAGAS 评测直觉:")
    for key, value in evaluation_result.items():
        print(f"{key}: {value}")


if __name__ == "__main__":
    print_ragas_result()
