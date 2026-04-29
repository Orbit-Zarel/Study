response = {
    "traceId": "trace-1001",
    "requestId": "req-2001",
    "route": "rag_pipeline",
    "model": "gpt-4o-mini",
    "answer": "这是统一响应格式示例",
    "citations": ["doc-1", "doc-2"],
    "usage": {"promptTokens": 120, "completionTokens": 48},
}


if __name__ == "__main__":
    print(response)
