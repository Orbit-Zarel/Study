package learning.spring_boot_basics.examples.dto;

// DTO = Data Transfer Object
// 你可以先把它理解为：
// “专门用来装接口输入输出数据的对象”。
public class TaskResponse {

    private Long id;
    private String title;
    private String status;

    public TaskResponse(Long id, String title, String status) {
        this.id = id;
        this.title = title;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getStatus() {
        return status;
    }
}
