public class ProviderRoutingDemo {

    public static void main(String[] args) {
        route("openai", "gpt-4o-mini");
        System.out.println("----");
        route("qwen", "qwen-max");
    }

    public static void route(String provider, String model) {
        System.out.println("收到模型调用请求");
        System.out.println("provider = " + provider);
        System.out.println("model = " + model);

        if ("openai".equals(provider)) {
            System.out.println("路由到 OpenAI Provider 实现");
        } else if ("qwen".equals(provider)) {
            System.out.println("路由到 Qwen Provider 实现");
        } else {
            System.out.println("未知 provider，无法处理");
        }
    }
}
