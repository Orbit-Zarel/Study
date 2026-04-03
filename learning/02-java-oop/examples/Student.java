public class Student {

    // 这些字段表示 Student 对象拥有的数据。
    String name;
    int age;
    String major;

    public Student(String name, int age, String major) {
        // this.name 表示“当前对象自己的 name 字段”。
        // 右边的 name 是构造方法的参数。
        this.name = name;
        this.age = age;
        this.major = major;
    }

    public void introduce() {
        System.out.println("大家好，我叫 " + name + "，今年 " + age + " 岁，专业方向是 " + major + "。");
    }

    public void study(String topic) {
        System.out.println(name + " 正在学习：" + topic);
    }
}
