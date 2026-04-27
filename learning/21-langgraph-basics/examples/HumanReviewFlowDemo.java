public class HumanReviewFlowDemo {

    public static void main(String[] args) {
        System.out.println("带人工审核的流程：");
        System.out.println();
        System.out.println("planner -> executor -> human_review -> final_writer -> end");
        System.out.println("human_review 节点负责决定是否继续自动流转");
    }
}
