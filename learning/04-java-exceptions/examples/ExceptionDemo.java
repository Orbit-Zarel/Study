public class ExceptionDemo {

    public static void main(String[] args) {
        System.out.println("程序开始");

        // 示例 1：字符串转数字时可能失败
        parseNumber("123");
        parseNumber("abc");

        System.out.println("----");

        // 示例 2：数组下标越界
        readArrayValue();

        System.out.println("程序结束");
    }

    public static void parseNumber(String text) {
        try {
            // Integer.parseInt 会尝试把字符串转成 int。
            // 如果字符串不是合法整数，就会抛出 NumberFormatException。
            int value = Integer.parseInt(text);
            System.out.println("转换成功，结果是：" + value);
        } catch (NumberFormatException e) {
            // catch 会捕获异常，避免程序直接崩掉。
            System.out.println("转换失败，输入不是合法整数：" + text);
            System.out.println("异常类型：" + e.getClass().getSimpleName());
        } finally {
            // finally 一般用于收尾逻辑。
            System.out.println("parseNumber 方法执行结束");
        }
    }

    public static void readArrayValue() {
        int[] numbers = {10, 20, 30};

        try {
            System.out.println("尝试读取数组下标 5 的值");
            System.out.println(numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("数组访问失败：下标越界");
            System.out.println("异常信息：" + e.getMessage());
        }
    }
}
