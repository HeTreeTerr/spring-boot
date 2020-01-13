package com.hss.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 监控信息受保护
 * 自定义健康状态指示器
 * 1、编写一个指示器 必须实现HealthIndicator
 * 2.指示器的名字  xxxHealthIndicator
 * 3.加入容器中
 */
@SpringBootApplication
public class SpringbootActuaorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootActuaorApplication.class, args);
    }
}
