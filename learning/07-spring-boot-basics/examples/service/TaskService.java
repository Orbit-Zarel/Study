package learning.spring_boot_basics.examples.service;

import learning.spring_boot_basics.examples.dto.TaskResponse;
import org.springframework.stereotype.Service;

// @Service 表示这是“业务逻辑层”的一个组件。
@Service
public class TaskService {

    public TaskResponse getDemoTask() {
        // 当前先返回一个写死的示例对象。
        // 后面你学到数据库后，这里就可能变成：
        // 1. 查数据库
        // 2. 做状态判断
        // 3. 组装响应结果
        return new TaskResponse(1L, "学习 Spring Boot", "PENDING");
    }
}
