public class ToolAndParserDemo {

    public static void main(String[] args) {
        System.out.println("Agent 调用工具：查询数据库");
        System.out.println("工具返回：{ \"company\": \"宁德时代\", \"revenue\": \"1023亿\" }");
        System.out.println("Output Parser 解析后：");
        System.out.println("company = 宁德时代");
        System.out.println("revenue = 1023亿");
    }
}
