def route_task(query_type: str):
    if query_type == "simple_chat":
        return "direct_llm"
    if query_type == "doc_qa":
        return "rag_pipeline"
    if query_type == "data_query":
        return "mcp_tool"
    return "agent_workflow"


if __name__ == "__main__":
    for query_type in ["simple_chat", "doc_qa", "data_query", "complex_analysis"]:
        print(f"{query_type} -> {route_task(query_type)}")
