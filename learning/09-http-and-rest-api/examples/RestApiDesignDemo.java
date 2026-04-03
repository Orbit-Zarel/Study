public class RestApiDesignDemo {

    public static void main(String[] args) {
        // 这个示例帮助你建立“URL + HTTP 方法 = 接口语义”的直觉。

        printApi("GET", "/api/tasks", "查询任务列表");
        printApi("GET", "/api/tasks/1", "查询单个任务详情");
        printApi("POST", "/api/tasks", "创建一个新任务");
        printApi("DELETE", "/api/tasks/1", "删除 id 为 1 的任务");
        printApi("POST", "/api/auth/login", "用户登录");
    }

    public static void printApi(String method, String url, String meaning) {
        System.out.println(method + " " + url + " -> " + meaning);
    }
}
