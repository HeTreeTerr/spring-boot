package com.itcast.springboot.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//注解掉 @Configuration 代码不生效
//@Configuration
//public class MymvcConfig2 implements WebMvcConfigurer {//推荐使用
    //addViewControllers
//@Configuration
public class MymvcConfig2 extends WebMvcConfigurationSupport{

    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        System.out.println("添加视图映射器");
        registry.addViewController("/index1.html").setViewName("login.html");
    }
}
