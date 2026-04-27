public class PlannerExecutorDemo {

    public static void main(String[] args) {
        System.out.println("Planner-Executor 模式：");
        System.out.println();

        planner();
        System.out.println("----");
        executor("postgres", "查询 agent_prompt 表");
        System.out.println("----");
        executor("mongodb", "查询日志集合");
    }

    public static void planner() {
        System.out.println("Planner 输出任务列表：");
        System.out.println("1. postgres -> 查询 agent_prompt 表");
        System.out.println("2. mongodb -> 查询日志集合");
    }

    public static void executor(String executorName, String taskGoal) {
        System.out.println("Executor = " + executorName);
        System.out.println("任务目标 = " + taskGoal);
        System.out.println("执行完成，返回中间结果");
    }
}
