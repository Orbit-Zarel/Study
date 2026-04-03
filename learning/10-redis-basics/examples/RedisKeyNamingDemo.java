public class RedisKeyNamingDemo {

    public static void main(String[] args) {
        // 这个示例帮助你理解：
        // Redis 的 key 通常不是随便乱写的，而是按一定命名规则组织。

        String userNameKey = "user:1:name";
        String taskStatusKey = "task:1001:status";
        String rateLimitKey = "rate_limit:user:1";

        System.out.println("示例 key 1: " + userNameKey);
        System.out.println("含义：用户 1 的姓名");

        System.out.println();

        System.out.println("示例 key 2: " + taskStatusKey);
        System.out.println("含义：任务 1001 的状态");

        System.out.println();

        System.out.println("示例 key 3: " + rateLimitKey);
        System.out.println("含义：用户 1 的限流计数相关键");
    }
}
