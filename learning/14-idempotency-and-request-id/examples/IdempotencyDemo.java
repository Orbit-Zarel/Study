import java.util.HashMap;
import java.util.Map;

public class IdempotencyDemo {

    // 用 Map 模拟“数据库里已经创建过的任务”
    // key = requestId
    // value = taskId
    private static final Map<String, String> existingTasks = new HashMap<>();

    public static void main(String[] args) {
        submitTask("req-1001");
        System.out.println("----");
        submitTask("req-1001");
        System.out.println("----");
        submitTask("req-1002");
    }

    public static void submitTask(String requestId) {
        System.out.println("收到创建任务请求，requestId = " + requestId);

        // 第一步：先检查这个 requestId 是否已经处理过
        if (existingTasks.containsKey(requestId)) {
            System.out.println("检测到重复请求，不再重复创建任务");
            System.out.println("直接返回已有 taskId = " + existingTasks.get(requestId));
            return;
        }

        // 第二步：如果没有处理过，才真正创建任务
        String taskId = "task-" + (existingTasks.size() + 1);
        existingTasks.put(requestId, taskId);

        System.out.println("成功创建任务，taskId = " + taskId);
    }
}
