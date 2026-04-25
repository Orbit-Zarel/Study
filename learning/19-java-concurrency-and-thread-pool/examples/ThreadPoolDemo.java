import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> printTask("task-1"));
        executorService.submit(() -> printTask("task-2"));
        executorService.submit(() -> printTask("task-3"));

        executorService.shutdown();
    }

    public static void printTask(String taskName) {
        System.out.println(
            Thread.currentThread().getName() + " 正在执行 " + taskName
        );
    }
}
