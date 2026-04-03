import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileWriteReadDemo {

    public static void main(String[] args) {
        // Path 表示文件路径。
        // 这里我们把示例文件放在当前 examples 目录下，方便你直接看到结果。
        Path path = Path.of("learning", "05-java-file-io", "examples", "sample-note.txt");

        try {
            // 写入文件：
            // 如果文件不存在，CREATE 会帮我们创建文件；
            // 如果文件已存在，TRUNCATE_EXISTING 会先清空旧内容再写入新内容。
            Files.writeString(
                path,
                "第一行：这是 Java 文件写入示例。\n第二行：文件内容已经成功写入。",
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING
            );

            System.out.println("文件写入成功：" + path);

            // 读取文件全部内容。
            String content = Files.readString(path);

            System.out.println("---- 读取到的文件内容 ----");
            System.out.println(content);
        } catch (IOException e) {
            // 文件读写失败时，常见异常就是 IOException 或它的子类。
            System.out.println("文件操作失败：" + e.getMessage());
        }
    }
}
