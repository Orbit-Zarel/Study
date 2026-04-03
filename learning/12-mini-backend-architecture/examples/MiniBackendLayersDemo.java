public class MiniBackendLayersDemo {

    public static void main(String[] args) {
        System.out.println("一个小型后端项目里的核心层次：");
        System.out.println();

        printLayer("Controller", "接收 HTTP 请求，返回响应");
        printLayer("Service", "处理业务逻辑");
        printLayer("Repository", "负责和数据库交互");
        printLayer("Redis", "负责缓存和临时状态");
        printLayer("Kafka", "负责异步消息");
        printLayer("External API", "负责调用外部系统，例如 LLM");
    }

    public static void printLayer(String name, String description) {
        System.out.println(name + " -> " + description);
    }
}
