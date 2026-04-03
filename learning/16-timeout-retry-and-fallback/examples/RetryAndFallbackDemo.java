public class RetryAndFallbackDemo {

    public static void main(String[] args) {
        System.out.println("模拟一次带有 timeout / retry / fallback 的调用流程：");
        System.out.println();

        step(1, "先调用主 provider：OpenAI");
        step(2, "第一次调用超时");
        step(3, "判断这是可重试错误");
        step(4, "对 OpenAI 发起第 2 次尝试");
        step(5, "第 2 次仍然失败");
        step(6, "检测到已启用 fallback");
        step(7, "切换到备用 provider：Qwen");
        step(8, "Qwen 调用成功，返回结果");
    }

    public static void step(int index, String description) {
        System.out.println("Step " + index + ": " + description);
    }
}
