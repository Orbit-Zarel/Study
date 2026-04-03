public class KafkaRoleDemo {

    public static void main(String[] args) {
        System.out.println("Kafka 中几个最重要的角色：");
        System.out.println();

        printRole("Producer", "负责发送消息");
        printRole("Topic", "负责承载某一类消息");
        printRole("Consumer", "负责消费消息并执行处理");
    }

    public static void printRole(String name, String description) {
        System.out.println(name + " -> " + description);
    }
}
