public class TraceLoggingDemo {

    public static void main(String[] args) {
        String traceId = "trace-1001";
        log(traceId, "api-gateway", "收到请求", "SUCCESS");
        log(traceId, "task-service", "创建任务", "SUCCESS");
        log(traceId, "llm-gateway", "调用 provider", "SUCCESS");
    }

    public static void log(String traceId, String serviceName, String action, String status) {
        System.out.println(
            "traceId=" + traceId
                + " service=" + serviceName
                + " action=" + action
                + " status=" + status
        );
    }
}
