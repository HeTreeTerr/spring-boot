package com.itcast.springboot.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 自定义
 */
@Configuration
public class MyCacheConfig {
    @Bean(value = "keyGenerator")
    public KeyGenerator keyGenerator(){
        return  new KeyGenerator(){
            @Override
            public Object generate(Object target, Method method, Object... params) {

                return method.getName()+"["+Arrays.asList(params.toString()) +"]";
            }
        };
    }
}
