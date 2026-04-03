public class ControlFlowDemo {

    public static void main(String[] args) {
        int score = 78;

        // if / else 用来根据条件执行不同代码。
        if (score >= 90) {
            System.out.println("成绩等级：优秀");
        } else if (score >= 60) {
            System.out.println("成绩等级：及格");
        } else {
            System.out.println("成绩等级：不及格");
        }

        System.out.println("---- for 循环示例 ----");

        // for 循环适合“已知循环次数”的场景。
        for (int i = 1; i <= 5; i++) {
            System.out.println("第 " + i + " 次循环");
        }

        System.out.println("---- while 循环示例 ----");

        int count = 3;

        // while 循环适合“满足条件就继续执行”的场景。
        while (count > 0) {
            System.out.println("倒计时：" + count);
            count--;
        }

        // 调用带返回值的方法。
        int result = add(10, 20);
        System.out.println("10 + 20 = " + result);
    }

    public static int add(int a, int b) {
        // return 表示把结果返回给调用方。
        return a + b;
    }
}
