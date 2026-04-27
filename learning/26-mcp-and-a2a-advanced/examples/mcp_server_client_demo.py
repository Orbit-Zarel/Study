def mcp_server(tool_name: str, params: dict):
    print(f"[server] 收到工具调用: {tool_name}")
    print(f"[server] 参数: {params}")
    return {"status": "success", "result": "返回工具执行结果"}


def mcp_client():
    tool_name = "get_a_stock_events"
    params = {"company_name": "宁德时代", "start_date": "2025-01-01"}

    print("[client] 发现可用工具")
    print(f"[client] 选择工具: {tool_name}")
    result = mcp_server(tool_name, params)
    print(f"[client] 得到结果: {result}")


if __name__ == "__main__":
    mcp_client()
