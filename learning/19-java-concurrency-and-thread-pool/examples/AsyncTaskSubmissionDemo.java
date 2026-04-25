import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncTaskSubmissionDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        System.out.println("收到创建任务请求");
        System.out.println("任务已提交到线程池，接口先返回 taskId = task-1001");

        executorService.submit(() -> {
            System.out.println("后台开始执行 task-1001");
            System.out.println("调用 LLM provider");
            System.out.println("更新任务状态为 SUCCEEDED");
        });

        executorService.shutdown();
    }
}
