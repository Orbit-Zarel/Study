public class SynthesizerFlowDemo {

    public static void main(String[] args) {
        System.out.println("Planner-Executor-Synthesizer 模式：");
        System.out.println();

        System.out.println("Planner：拆成两个子任务");
        System.out.println("Executor-1：查 PostgreSQL");
        System.out.println("Executor-2：查 MongoDB");
        System.out.println("Synthesizer：读取两个中间结果并生成最终回答");
    }
}
