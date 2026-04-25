public class LlmAuditLogDemo {

    public static void main(String[] args) {
        printAuditLog(
            "trace-2001",
            "req-3001",
            "user-7",
            "openai",
            "gpt-4o-mini",
            true,
            1260,
            "SUCCESS"
        );
    }

    public static void printAuditLog(
        String traceId,
        String requestId,
        String userId,
        String provider,
        String model,
        boolean fallbackUsed,
        int latencyMs,
        String status
    ) {
        System.out.println(
            "traceId=" + traceId
                + " requestId=" + requestId
                + " userId=" + userId
                + " provider=" + provider
                + " model=" + model
                + " fallbackUsed=" + fallbackUsed
                + " latencyMs=" + latencyMs
                + " status=" + status
        );
    }
}
