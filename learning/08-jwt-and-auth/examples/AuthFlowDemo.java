public class AuthFlowDemo {

    public static void main(String[] args) {
        String username = "alice";
        String password = "123456";

        // 第一步：模拟登录
        String token = login(username, password);

        System.out.println("登录后拿到的 token: " + token);
        System.out.println("----");

        // 第二步：带着 token 访问受保护接口
        accessProtectedResource(token);

        System.out.println("----");

        // 第三步：不带 token 再访问一次，感受差异
        accessProtectedResource(null);
    }

    public static String login(String username, String password) {
        // 这里我们用最简单的方式模拟“账号密码校验”。
        // 真实项目里通常会查数据库、校验密码哈希，而不是写死在代码里。
        if ("alice".equals(username) && "123456".equals(password)) {
            // 这里只是一个“模拟 token”，帮助你理解登录流程。
            // 它不是真正的 JWT，只是为了让你先建立流程感。
            return "mock-token-for-" + username;
        }

        throw new IllegalArgumentException("用户名或密码错误");
    }

    public static void accessProtectedResource(String token) {
        System.out.println("尝试访问受保护资源...");

        // 受保护接口的第一件事，通常就是检查身份凭证是否存在。
        if (token == null || token.isBlank()) {
            System.out.println("访问失败：没有提供 token");
            return;
        }

        // 这里我们继续做最简化校验。
        // 真实项目里会校验签名、过期时间、用户身份等。
        if (token.startsWith("mock-token-for-")) {
            System.out.println("访问成功：token 合法，允许访问数据");
        } else {
            System.out.println("访问失败：token 非法");
        }
    }
}
