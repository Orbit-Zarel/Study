package learning.spring_boot_basics.examples.controller;

import learning.spring_boot_basics.examples.dto.TaskResponse;
import learning.spring_boot_basics.examples.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 这个示例演示一个更像真实项目的 Controller。
// 它不直接写死所有逻辑，而是把业务处理交给 Service。
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    // 构造方法注入：
    // 当前阶段你可以先把它理解为：
    // Spring 会帮我们准备好 TaskService，然后传进来。
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/demo")
    public TaskResponse getDemoTask() {
        return taskService.getDemoTask();
    }
}
