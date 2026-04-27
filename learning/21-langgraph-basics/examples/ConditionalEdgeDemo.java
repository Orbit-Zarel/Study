public class ConditionalEdgeDemo {

    public static void main(String[] args) {
        String plannerStatus = "SUCCESS";

        System.out.println("当前节点 = planner");
        System.out.println("plannerStatus = " + plannerStatus);

        if ("SUCCESS".equals(plannerStatus)) {
            System.out.println("下一条边：planner -> executor");
        } else {
            System.out.println("下一条边：planner -> fallback_handler");
        }
    }
}
