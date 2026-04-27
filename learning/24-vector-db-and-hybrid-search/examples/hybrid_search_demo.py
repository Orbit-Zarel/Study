dense_results = [
    {"id": "doc-1", "source": "dense", "score": 0.91, "text": "营收提升，利润增长。"},
    {"id": "doc-3", "source": "dense", "score": 0.83, "text": "海外销量增长。"},
]

sparse_results = [
    {"id": "doc-2", "source": "sparse", "score": 12.4, "text": "2025Q4 财报显示利润同比增长 18%。"},
    {"id": "doc-1", "source": "sparse", "score": 10.8, "text": "营收提升，利润增长。"},
]


def hybrid_search():
    print("dense retrieval 结果:")
    for item in dense_results:
        print(item)

    print("\nsparse retrieval 结果:")
    for item in sparse_results:
        print(item)

    merged = {}
    for item in dense_results + sparse_results:
        if item["id"] not in merged:
            merged[item["id"]] = item

    print("\nmerge 后结果:")
    for item in merged.values():
        print(item)


if __name__ == "__main__":
    hybrid_search()
