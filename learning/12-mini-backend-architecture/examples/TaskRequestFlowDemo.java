public class TaskRequestFlowDemo {

    public static void main(String[] args) {
        System.out.println("模拟一次 POST /api/tasks 请求在系统中的流动：");
        System.out.println();

        step(1, "客户端发起 POST /api/tasks，并携带 JWT");
        step(2, "TaskController 接收请求");
        step(3, "TaskService 校验参数和用户身份");
        step(4, "TaskService 把任务写入 MySQL");
        step(5, "TaskService 把 taskId 发送到 Kafka");
        step(6, "接口先返回：任务已提交");
        step(7, "后台 Consumer 从 Kafka 取出 taskId");
        step(8, "Consumer 执行任务，例如调用 LLM");
        step(9, "Consumer 更新任务状态为 SUCCEEDED 或 FAILED");
        step(10, "用户稍后用 GET /api/tasks/{id} 查询任务状态");
        step(11, "查询结果可以优先读取 Redis，必要时回源 MySQL");
    }

    public static void step(int index, String description) {
        System.out.println("Step " + index + ": " + description);
    }
}
