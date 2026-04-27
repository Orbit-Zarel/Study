candidates = [
    {"id": "doc-1", "retrieval_score": 0.88, "rerank_score": 0.72, "text": "公司收入增长。"},
    {"id": "doc-2", "retrieval_score": 0.84, "rerank_score": 0.95, "text": "利润同比增长 18%，回答最贴近问题。"},
    {"id": "doc-3", "retrieval_score": 0.82, "rerank_score": 0.68, "text": "行业背景介绍。"},
]


def show_rerank():
    print("第一轮 retrieval 结果:")
    for item in candidates:
        print(item)

    reranked = sorted(candidates, key=lambda x: x["rerank_score"], reverse=True)

    print("\n第二轮 rerank 结果:")
    for item in reranked:
        print(item)


if __name__ == "__main__":
    show_rerank()
