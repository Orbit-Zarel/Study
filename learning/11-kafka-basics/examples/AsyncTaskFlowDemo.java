import java.util.LinkedList;
import java.util.Queue;

public class AsyncTaskFlowDemo {

    // 用一个最简单的队列模拟 Kafka Topic。
    private static final Queue<String> taskQueue = new LinkedList<>();

    public static void main(String[] args) {
        // 模拟用户提交两个任务
        submitTask("task-1001");
        submitTask("task-1002");

        System.out.println();

        // 模拟 Consumer 开始处理队列中的任务
        consumeTasks();
    }

    public static void submitTask(String taskId) {
        System.out.println("收到创建任务请求，taskId = " + taskId);
        System.out.println("Producer 把任务消息发送到队列");

        taskQueue.offer(taskId);

        System.out.println("接口可以先快速返回：任务已提交，稍后异步执行");
    }

    public static void consumeTasks() {
        System.out.println("Consumer 开始消费任务...");

        while (!taskQueue.isEmpty()) {
            String taskId = taskQueue.poll();

            System.out.println("取到消息：" + taskId);
            System.out.println("开始执行任务：" + taskId);
            System.out.println("任务执行完成，更新状态为 SUCCEEDED");
            System.out.println("----");
        }
    }
}
