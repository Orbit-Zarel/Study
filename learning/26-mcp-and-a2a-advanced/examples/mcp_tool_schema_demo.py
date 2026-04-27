tool_schema = {
    "name": "get_a_stock_events",
    "description": "查询 A 股上市公司的业绩会和调研事件",
    "input_schema": {
        "company_name": {"type": "string", "required": True},
        "start_date": {"type": "string", "required": False},
        "end_date": {"type": "string", "required": False},
    },
}


def show_schema():
    print("一个最小 MCP tool schema:")
    for key, value in tool_schema.items():
        print(f"{key}: {value}")


if __name__ == "__main__":
    show_schema()
