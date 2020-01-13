package com.itcast.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot默认支持两种技术来和ES交互
 * 1.Jest(默认不生效，需导入 io.searchbox.client.JestClient)
 * 2.SpringData ElasticSearch
 *      1）Client 节点信息 clusterNodes clusterName
 *      2) ElasticsearchTemplate 操作Es
 *      3) 编写一个ElasticsearchRepository的子接口来操作Es
 *
 * https://github.com/spring-projects/spring-data-elasticsearch
 *版本适配
 * spring data elasticsearch	elasticsearch
 * 3.1.x	6.2.2
 * 3.0.x	5.5.0
 * 2.1.x	2.4.0
 * 2.0.x	2.2.0
 * 1.3.x	1.5.2
 * 如果版本不适配：
 * 1）升级springboot版本
 * 2）安装对应版本的ES
 */
@SpringBootApplication
public class SpringBootElasticApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootElasticApplication.class, args);
    }
}
