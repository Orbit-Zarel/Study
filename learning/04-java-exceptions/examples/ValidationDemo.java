public class ValidationDemo {

    public static void main(String[] args) {
        printAgeMessage(20);

        try {
            printAgeMessage(-3);
        } catch (IllegalArgumentException e) {
            System.out.println("捕获到业务校验异常：" + e.getMessage());
        }
    }

    public static void printAgeMessage(int age) {
        // 这里演示“主动抛出异常”。
        // 当参数明显不合理时，我们可以直接阻止后续逻辑继续执行。
        if (age < 0) {
            throw new IllegalArgumentException("年龄不能是负数，当前 age = " + age);
        }

        System.out.println("当前年龄合法：" + age);
    }
}
