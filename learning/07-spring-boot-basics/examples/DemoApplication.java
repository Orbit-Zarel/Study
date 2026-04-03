package learning.spring_boot_basics.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication 是 Spring Boot 项目的常见启动注解。
// 当前阶段你可以先把它理解为：
// “告诉 Spring Boot：从这里开始启动整个应用”。
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        // SpringApplication.run(...) 会启动内置 Web 服务，
        // 然后让你的 Controller 可以开始接收 HTTP 请求。
        SpringApplication.run(DemoApplication.class, args);
    }
}
