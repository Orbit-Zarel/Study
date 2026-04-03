public class HelloJava {

    public static void main(String[] args) {
        // 这是程序入口。运行这个类时，Java 会从 main 方法开始执行。

        System.out.println("Hello, Java!");
        System.out.println("这是一段最基础的 Java 程序。");

        // 定义几个最常见的变量，感受不同类型的写法。
        String name = "Zarel";
        int studyDays = 7;
        double progress = 0.35;
        boolean likesJava = true;

        // 通过字符串拼接把变量打印出来。
        System.out.println("name = " + name);
        System.out.println("studyDays = " + studyDays);
        System.out.println("progress = " + progress);
        System.out.println("likesJava = " + likesJava);

        // 调用下面我们自己写的方法。
        greet(name);
    }

    public static void greet(String name) {
        // 这个方法接收一个字符串参数，然后打印欢迎语。
        System.out.println("欢迎你回来学习 Java, " + name + "!");
    }
}
