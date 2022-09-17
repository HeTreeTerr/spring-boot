package com.itcast.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 自定义线程池配置
 */
@Configuration
public class MyThreadPoolConfig {

    /**
     * 配置自定义线程池
     * @return
     */
    @Bean(value = "myExecutorService")
    public ExecutorService executorService(){
        return Executors.newFixedThreadPool(5);
    }
}
