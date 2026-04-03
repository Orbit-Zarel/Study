package learning.spring_boot_basics.examples.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController 表示这是一个“处理 Web 请求并直接返回结果”的类。
@RestController
public class HelloController {

    // @GetMapping("/hello") 表示：
    // 当用户访问 GET /hello 时，就执行这个方法。
    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring Boot";
    }
}
