system_prompt = "你是一个金融分析 Agent。必须基于证据回答，证据不足时明确说明。"
task_prompt = "请总结宁德时代 2025Q4 的利润变化。"
output_prompt = "请输出 JSON，字段包括 summary、evidence、risk_points。"


def show_prompt_layers():
    print("system prompt:")
    print(system_prompt)
    print("\ntask prompt:")
    print(task_prompt)
    print("\noutput prompt:")
    print(output_prompt)


if __name__ == "__main__":
    show_prompt_layers()
