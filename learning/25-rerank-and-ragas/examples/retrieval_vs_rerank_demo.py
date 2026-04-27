retrieval_results = [
    "doc-7: 关键词命中，但和问题关系一般",
    "doc-3: 提到了公司利润，但不是本季度",
    "doc-2: 直接回答了本季度利润变化",
]

rerank_results = [
    "doc-2: 直接回答了本季度利润变化",
    "doc-3: 提到了公司利润，但不是本季度",
    "doc-7: 关键词命中，但和问题关系一般",
]


def compare():
    print("retrieval 阶段:")
    for item in retrieval_results:
        print(item)

    print("\nrerank 阶段:")
    for item in rerank_results:
        print(item)


if __name__ == "__main__":
    compare()
