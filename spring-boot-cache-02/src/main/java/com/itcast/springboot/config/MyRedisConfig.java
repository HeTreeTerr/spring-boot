package com.itcast.springboot.config;

import com.itcast.springboot.bean.Employee;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

@Configuration
public class MyRedisConfig {
    @Bean
    public RedisTemplate<Object, Employee> empRedisTemplate(
            RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, Employee> template = new RedisTemplate<Object, Employee>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Employee> serializer = new Jackson2JsonRedisSerializer<Employee>(Employee.class);
        template.setDefaultSerializer(serializer);
        return template;
    }

//springboot1.0版本使用，springboot2待续
//CacheManagerCustomizers可以来定制缓存的一些规则
    @Bean
    public RedisCacheManager empCacheManager(RedisTemplate<Object, Employee> empRedisTemplate) {
        RedisCacheManager cacheManager= new RedisCacheManager(empRedisTemplate);
        cacheManager.setUsePrefix(true);
//可引入自定义配置，一般不用
//        List<String> cacheNames = this.cacheProperties.getCacheNames();
//        if (!cacheNames.isEmpty()) {
//            cacheManager.setCacheNames(cacheNames);
//        }
//        return this.customizerInvoker.customize(cacheManager);
        return cacheManager;
    }

}
