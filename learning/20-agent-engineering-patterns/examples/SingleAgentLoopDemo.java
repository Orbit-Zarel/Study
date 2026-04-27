public class SingleAgentLoopDemo {

    public static void main(String[] args) {
        System.out.println("单 Agent 最小执行链路：");
        System.out.println();

        step(1, "收到用户问题");
        step(2, "判断需要调用工具");
        step(3, "调用数据库查询工具");
        step(4, "读取工具结果");
        step(5, "整理最终回答");
        step(6, "返回给用户");
    }

    public static void step(int index, String description) {
        System.out.println("Step " + index + ": " + description);
    }
}
