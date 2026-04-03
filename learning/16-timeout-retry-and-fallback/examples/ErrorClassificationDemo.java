public class ErrorClassificationDemo {

    public static void main(String[] args) {
        classify("TIMEOUT");
        System.out.println("----");
        classify("HTTP_500");
        System.out.println("----");
        classify("HTTP_400");
        System.out.println("----");
        classify("INVALID_API_KEY");
    }

    public static void classify(String errorType) {
        System.out.println("错误类型：" + errorType);

        if ("TIMEOUT".equals(errorType) || "HTTP_500".equals(errorType)) {
            System.out.println("判断结果：可重试");
        } else {
            System.out.println("判断结果：通常不应重试");
        }
    }
}
