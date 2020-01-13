package com.itcast.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 搭建基本环境
 * 1.导入数据库文件 创建department和employee表
 * 2.创建javabean
 * 3.整合mybatis操作数据库
 *      1.配置数据源
 *      2.使用mybatis（注解）
 *          1）@MapperScan指定需要扫描的mapper接口所在的包
 *4.快速体验缓存
 *      1.开启基于注解的缓存(@EnableCaching)
 * 		2.标注缓存注解即可
 */
@SpringBootApplication
@MapperScan(value = "com.itcast.springboot.mapper")
@EnableCaching
public class SpringBootCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCacheApplication.class, args);
    }
}
