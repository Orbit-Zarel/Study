public class TaskStatusFlowDemo {

    public static void main(String[] args) {
        String status = "PENDING";
        System.out.println("任务初始状态：" + status);

        status = moveTo(status, "QUEUED");
        status = moveTo(status, "RUNNING");
        status = moveTo(status, "SUCCEEDED");

        System.out.println("任务最终状态：" + status);
    }

    public static String moveTo(String currentStatus, String nextStatus) {
        System.out.println("状态流转：" + currentStatus + " -> " + nextStatus);
        return nextStatus;
    }
}
