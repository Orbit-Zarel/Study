chunks = ["这是", "一个", "流式", "输出", "示例"]


if __name__ == "__main__":
    rendered = ""
    for chunk in chunks:
        rendered += chunk
        print(rendered)
