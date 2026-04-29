def api_handler(request: dict):
    print("[api] 收到请求")
    return service_layer(request)


def service_layer(request: dict):
    print("[service] 做任务分类与链路编排")
    return {"answer": f"处理完成: {request['message']}"}


if __name__ == "__main__":
    response = api_handler({"message": "总结这份财报"})
    print(response)
