package com.itcast.springboot;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//开启基于注解的RabbitMQ模式
@EnableRabbit
@SpringBootApplication
public class SpringBoot15Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot15Application.class, args);
    }
}
