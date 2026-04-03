import java.util.HashMap;
import java.util.Map;

public class CacheFlowDemo {

    // 用 HashMap 模拟 Redis 缓存
    private static final Map<String, String> cache = new HashMap<>();

    // 用另一个 HashMap 模拟数据库
    private static final Map<String, String> database = new HashMap<>();

    public static void main(String[] args) {
        // 先准备一条“数据库中的数据”
        database.put("task:1001:status", "RUNNING");

        System.out.println("第一次查询：缓存里还没有数据");
        String firstResult = getTaskStatus("task:1001:status");
        System.out.println("结果：" + firstResult);

        System.out.println();

        System.out.println("第二次查询：这次应该直接命中缓存");
        String secondResult = getTaskStatus("task:1001:status");
        System.out.println("结果：" + secondResult);
    }

    public static String getTaskStatus(String key) {
        // 第一步：先查缓存
        if (cache.containsKey(key)) {
            System.out.println("缓存命中，直接从缓存返回");
            return cache.get(key);
        }

        System.out.println("缓存未命中，开始查询数据库");

        // 第二步：缓存里没有，再查数据库
        String dbValue = database.get(key);

        // 第三步：把数据库结果写回缓存，方便下次更快读取
        if (dbValue != null) {
            cache.put(key, dbValue);
            System.out.println("已将数据库结果写入缓存");
        }

        return dbValue;
    }
}
