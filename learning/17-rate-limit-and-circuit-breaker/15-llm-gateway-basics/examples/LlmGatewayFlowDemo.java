public class LlmGatewayFlowDemo {

    public static void main(String[] args) {
        System.out.println("一个最小 LLM Gateway 调用流程：");
        System.out.println();

        step(1, "调用方请求 POST /api/llm/generate");
        step(2, "请求中传入 provider、model、messages");
        step(3, "Gateway 根据 provider 选择供应商实现");
        step(4, "Gateway 调用真实的大模型 API");
        step(5, "Gateway 统一整理输出结果");
        step(6, "返回 text、usage、provider、model、latencyMs");
    }

    public static void step(int index, String description) {
        System.out.println("Step " + index + ": " + description);
    }
}
