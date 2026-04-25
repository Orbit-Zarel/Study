import java.util.HashMap;
import java.util.Map;

public class RateLimitDemo {

    private static final int LIMIT = 3;
    private static final Map<String, Integer> counters = new HashMap<>();

    public static void main(String[] args) {
        allowRequest("user-1001");
        System.out.println("----");
        allowRequest("user-1001");
        System.out.println("----");
        allowRequest("user-1001");
        System.out.println("----");
        allowRequest("user-1001");
    }

    public static void allowRequest(String userId) {
        int currentCount = counters.getOrDefault(userId, 0) + 1;
        counters.put(userId, currentCount);

        System.out.println("收到请求，userId = " + userId);
        System.out.println("当前窗口计数 = " + currentCount);

        if (currentCount > LIMIT) {
            System.out.println("触发限流，拒绝本次请求");
            return;
        }

        System.out.println("未超过阈值，允许继续处理");
    }
}
