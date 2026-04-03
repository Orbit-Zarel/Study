import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionDemo {

    public static void main(String[] args) {
        // ----------------------------
        // 1. 数组：长度固定，适合最简单的一批同类型数据
        // ----------------------------
        int[] scores = {88, 92, 76};

        System.out.println("数组中的第一个成绩：" + scores[0]);

        // ----------------------------
        // 2. List：可变长度，有顺序
        // ----------------------------
        List<String> tasks = new ArrayList<>();

        tasks.add("阅读 Java 基础");
        tasks.add("运行示例代码");
        tasks.add("整理学习笔记");

        System.out.println("---- 遍历 List ----");

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("任务 " + (i + 1) + "：" + tasks.get(i));
        }

        // ----------------------------
        // 3. Map：键值对结构
        // ----------------------------
        Map<String, Integer> studyHours = new HashMap<>();

        studyHours.put("Monday", 1);
        studyHours.put("Tuesday", 2);
        studyHours.put("Wednesday", 1);

        System.out.println("---- 遍历 Map ----");

        for (String day : studyHours.keySet()) {
            System.out.println(day + " 学习了 " + studyHours.get(day) + " 小时");
        }

        // 计算总学习时长，感受集合在统计场景中的用途。
        int totalHours = 0;

        for (Integer hours : studyHours.values()) {
            totalHours += hours;
        }

        System.out.println("总学习时长：" + totalHours + " 小时");
    }
}
