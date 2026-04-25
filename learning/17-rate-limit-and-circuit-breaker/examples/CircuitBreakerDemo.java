public class CircuitBreakerDemo {

    private static final int FAILURE_THRESHOLD = 2;
    private static int failureCount = 0;
    private static String circuitState = "CLOSED";

    public static void main(String[] args) {
        callProvider(false);
        System.out.println("----");
        callProvider(false);
        System.out.println("----");
        callProvider(true);
    }

    public static void callProvider(boolean shouldSucceed) {
        System.out.println("当前熔断状态 = " + circuitState);

        if ("OPEN".equals(circuitState)) {
            System.out.println("熔断已打开，直接拒绝访问下游");
            return;
        }

        System.out.println("开始调用下游 provider");

        if (shouldSucceed) {
            System.out.println("下游调用成功");
            failureCount = 0;
            circuitState = "CLOSED";
            return;
        }

        failureCount++;
        System.out.println("下游调用失败，failureCount = " + failureCount);

        if (failureCount >= FAILURE_THRESHOLD) {
            circuitState = "OPEN";
            System.out.println("连续失败达到阈值，打开熔断");
        }
    }
}
