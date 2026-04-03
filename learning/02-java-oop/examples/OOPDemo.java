public class OOPDemo {

    public static void main(String[] args) {
        // 使用 new 关键字创建对象。
        Student student1 = new Student("Alice", 21, "Java 后端");
        Student student2 = new Student("Bob", 22, "AI 平台");

        // 对象可以调用自己的方法。
        student1.introduce();
        student1.study("类和对象");

        student2.introduce();
        student2.study("Spring Boot");
    }
}
