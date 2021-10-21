package com.itcast.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springBoot jar/war jvm参数调优
 * java -server -Xms512m -Xmx512m -jar spring-boot-jsp-0.0.1-SNAPSHOT.war
 */
@SpringBootApplication
public class SpringBootJspApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJspApplication.class, args);
    }
}
