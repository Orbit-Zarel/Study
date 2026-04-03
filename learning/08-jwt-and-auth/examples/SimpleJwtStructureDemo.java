public class SimpleJwtStructureDemo {

    public static void main(String[] args) {
        // 这里只是为了说明 JWT 的“结构长相”。
        // 注意：这不是安全的 JWT 生成方式，只是帮助你理解它通常分为三段。
        String header = "header-part";
        String payload = "payload-part";
        String signature = "signature-part";

        String fakeJwt = header + "." + payload + "." + signature;

        System.out.println("一个模拟 JWT 看起来像这样：");
        System.out.println(fakeJwt);
        System.out.println("----");

        String[] parts = fakeJwt.split("\\.");

        System.out.println("JWT 总共有 " + parts.length + " 段");
        System.out.println("第 1 段（Header）: " + parts[0]);
        System.out.println("第 2 段（Payload）: " + parts[1]);
        System.out.println("第 3 段（Signature）: " + parts[2]);
    }
}
