documents = [
    {"id": "doc-1", "text": "宁德时代本季度营收提升，利润同比增长。", "score": 0.92},
    {"id": "doc-2", "text": "公司毛利率改善，成本控制效果明显。", "score": 0.86},
    {"id": "doc-3", "text": "海外市场销量增长带动整体收入。", "score": 0.79},
]


def dense_retrieve(query: str, top_k: int = 2):
    print(f"查询问题: {query}")
    print("按语义相似度排序后取 top-k:")
    for item in documents[:top_k]:
        print(f"{item['id']} | score={item['score']} | {item['text']}")


if __name__ == "__main__":
    dense_retrieve("公司本季度收入增长情况如何？")
