def call_primary_model():
    print("调用主模型: primary-model")
    return {"status": "timeout"}


def call_fallback_model():
    print("切换到备用模型: fallback-model")
    return {"status": "success", "answer": "这是备用模型返回的结果"}


def main():
    result = call_primary_model()

    if result["status"] != "success":
        print("主模型失败，触发 fallback")
        result = call_fallback_model()

    print(f"最终结果: {result}")


if __name__ == "__main__":
    main()
