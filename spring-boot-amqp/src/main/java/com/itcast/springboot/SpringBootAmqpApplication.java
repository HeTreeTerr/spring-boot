package com.itcast.springboot;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自动配置类：RabbitAutoConfiguration
 *      1.自动配置连接工厂ConnectionFactory
 *      2.RabbitProperties 封装了RabbitMQ的配置
 *      3.RabbitTemplate:给RabbitMQ发送和接收消息
 *      4.AmqpAdmin: RabbitMQ系统管理功能组件
 *      5.@EnableRabbit + @RabbitListener
 *
 *
 */
@EnableRabbit
@SpringBootApplication
public class SpringBootAmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAmqpApplication.class, args);
    }
}
