public class RequestIdFlowDemo {

    public static void main(String[] args) {
        System.out.println("一个最小 requestId 幂等流程：");
        System.out.println();

        step(1, "客户端生成 requestId");
        step(2, "客户端调用 POST /api/tasks");
        step(3, "服务端先检查 requestId 是否已存在");
        step(4, "如果不存在，则创建任务");
        step(5, "如果已存在，则直接返回已有任务");
        step(6, "避免重复创建、重复发送消息、重复执行");
    }

    public static void step(int index, String description) {
        System.out.println("Step " + index + ": " + description);
    }
}
