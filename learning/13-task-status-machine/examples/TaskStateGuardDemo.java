public class TaskStateGuardDemo {

    public static void main(String[] args) {
        tryTransition("PENDING", "QUEUED");
        tryTransition("RUNNING", "SUCCEEDED");
        tryTransition("SUCCEEDED", "RUNNING");
        tryTransition("CANCELED", "RUNNING");
    }

    public static void tryTransition(String currentStatus, String nextStatus) {
        System.out.println("尝试状态流转：" + currentStatus + " -> " + nextStatus);

        if (isAllowed(currentStatus, nextStatus)) {
            System.out.println("允许流转");
        } else {
            System.out.println("不允许流转");
        }

        System.out.println("----");
    }

    public static boolean isAllowed(String currentStatus, String nextStatus) {
        if ("PENDING".equals(currentStatus) && ("QUEUED".equals(nextStatus) || "CANCELED".equals(nextStatus))) {
            return true;
        }

        if ("QUEUED".equals(currentStatus) && ("RUNNING".equals(nextStatus) || "CANCELED".equals(nextStatus))) {
            return true;
        }

        if ("RUNNING".equals(currentStatus) && ("SUCCEEDED".equals(nextStatus) || "FAILED".equals(nextStatus))) {
            return true;
        }

        if ("FAILED".equals(currentStatus) && "QUEUED".equals(nextStatus)) {
            // 这里表示“失败后允许手动重试”
            return true;
        }

        return false;
    }
}
