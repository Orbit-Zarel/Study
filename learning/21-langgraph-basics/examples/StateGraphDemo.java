public class StateGraphDemo {

    public static void main(String[] args) {
        System.out.println("一个最小 LangGraph 直觉：");
        System.out.println();
        System.out.println("start -> planner -> executor -> synthesizer -> end");
        System.out.println();
        System.out.println("状态在节点之间流转：");
        System.out.println("question -> plan -> toolResult -> finalAnswer");
    }
}
