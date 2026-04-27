dataset = [
    {
        "instruction": "请总结公司本季度利润变化",
        "input": "营收同比增长 18%，原材料成本下降。",
        "output": "公司本季度利润改善，主要由收入增长和成本下降共同推动。",
    },
    {
        "instruction": "请输出 JSON 格式摘要",
        "input": "公司海外销量增长，带动整体收入提升。",
        "output": '{"summary": "海外销量增长带动收入提升"}',
    },
]


def show_dataset():
    print("一个最小 SFT 数据集直觉:")
    for item in dataset:
        print(item)


if __name__ == "__main__":
    show_dataset()
