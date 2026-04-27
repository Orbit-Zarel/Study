public class PromptTemplateDemo {

    public static void main(String[] args) {
        String template = "请总结公司 {companyName} 在 {quarter} 的业绩要点。";
        String prompt = template
            .replace("{companyName}", "宁德时代")
            .replace("{quarter}", "2025Q4");

        System.out.println("Prompt Template:");
        System.out.println(template);
        System.out.println();
        System.out.println("填充后的 Prompt:");
        System.out.println(prompt);
    }
}
