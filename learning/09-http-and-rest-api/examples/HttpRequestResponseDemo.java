public class HttpRequestResponseDemo {

    public static void main(String[] args) {
        // 这里我们不用真正发网络请求，
        // 而是用“打印模拟”的方式帮助你理解 HTTP 请求与响应结构。

        System.out.println("===== 模拟一次 HTTP 请求 =====");
        System.out.println("Method: POST");
        System.out.println("URL: /api/auth/login");
        System.out.println("Header: Content-Type = application/json");
        System.out.println("Body: {\"username\":\"alice\", \"password\":\"123456\"}");

        System.out.println();

        System.out.println("===== 模拟一次 HTTP 响应 =====");
        System.out.println("Status: 200 OK");
        System.out.println("Header: Content-Type = application/json");
        System.out.println("Body: {\"token\":\"mock-jwt-token\"}");
    }
}
