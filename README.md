# spring-boot
## 1.springboot简介
>简化Spring应用开发的一个框架;  
整个Spring技术栈的一个大整合；  
J2EE开发的一站式解决方案；

## 2.微服务
微服务：架构风格（服务微化） 一个应用应该是一组小型服务；  
可以通过HTTP的方式进行互通；  
单体应用：ALL IN ONE 微服务：每一个功能元素最终都是一个可独立替换和独立升级的软件
单元；

## 3.仓库模块介绍
### 3.1spring-boot-jsp
如果历史ssm项目想升级使用springBoot，但是有jsp页面等历史包袱，全部升级重写代价太大。  
可以在springBoot项目中使用外置的tomcat，以此达到在同一微服务中同时使用springBoot
和jsp的目的。  
**注意**：项目打包会生成war包，实属无奈之举，不推荐使用。

### 3.2spring-boot-jdbc
springBoot整合druid数据源，通过JdbcTemplate工具类实现mysql数据库链接。

### 3.3spring-boot-jpa
springBoot整合jpa，实现mysql数据库链接。
1. 继承JpaRepository，无需编写sql语句，即可完成对数据库的基本操作
2. 如果遇到复杂逻辑场景，可以自定义sql语句
3. 实现表与表之间的关系映射（一对多、一对一等）

### 3.4spring-boot-mybatis
springBoot整合druid数据源和mybatis，实现mysql数据库链接。
1. 指定mybatis的配置文件，mybatis/mybatis-config.xml
2. 通过com.itcast.springboot.config.MyBatisConfig，配置mybatis属性
3. 在mybatis/mapper/EmployeeMapper.xml中自定义sql语句。
4. 在com.itcast.springboot.mapper.DepartmentMapper类中定义sql语句。
5. 在com.itcast.springboot.controller.DeptController.addDept方法
上，使用jsr303效验

### 3.5spring-boot-task
使用springBoot自带的定时任务框架，启动定时任务。
1. 在com.hss.springboot.service.ScheduledService.hello方法上，标注
@Scheduled，定义cron表达式，实现简单的定时任务。
2. 在com.hss.springboot.service.AsynService.hello方法上，标注@Async，
实现异步方法调用。

### 3.6spring-boot-web
springBoot以thymeleaf作为模板引擎，搭建后台管理界面，提供功能模块的增删改查
功能交互。  
访问地址：http://localhost:20000/crud/  
账号密码：admin/123456  
**注意**：没有实现mysql访问，接口返回数据由HashMap提供

### 3.7spring-boot-security
springBoot整合springSecurity安全框架，实现用户权限管理。
1. 在com.itcast.springboot.config.MySecurityConfig中，定义三个用户（hss、
hww、lll），定义三个角色（VIP1、VIP2、VIP3）。指定用户和角色的关系，指定接口url
和角色的关系。
2. 访问http://localhost:8080/ ，分别使用不同的用户登录系统，实现不同角色用户，
分配不同权限。

### 3.8spring-boot-logging
springBoot默认日志框架logback，设定日志路径、级别、格式配置。
1. 在application.properties中配置日志属性。
2. 在logback-spring.xml中配置日志文件属性。

### 3.9spring-boot-deploy
springBoot项目热部署，开发神器。在修改代码后，不用重启服务，使用快捷键：ctrl+f9，
改动即可生效。

1. http://localhost:8080/abc即可访问templates/hello.html页面。
2. 修改templates/hello.html，idea中ctrl+f9后，刷新浏览器页面，发现修改以生效。
```xml
<!-- pom中引入，热部署模块 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
</dependency>
```

### 3.10spring-boot-actuaor
springBoot自带的监控神器Actuator。
1. /health/{component}/{instance} GET  
报告程序的健康指标，这些数据由HealthIndicator实现类提供
http://localhost:8080/actuator/health/

2.  /info GET  
获取程序指定发布的信息，这些信息由配置文件中info打头的属性提供  
http://localhost:8080/actuator/info

3. /configprops GET  
描述配置属性（包含默认值）如何注入到bean  
http://localhost:8080/actuator/configprops

4. /beans GET
描述程序中的bean，及之间的依赖关系  
http://localhost:8080/actuator/beans

5. /env GET  
获取全部环境属性  
http://localhost:8080/actuator/env

6. /env/{name} GET    
根据名称获取指定的环境属性值  
http://localhost:8080/actuator/env/test

7. /mappings GET  
描述全部的URI路径，及和控制器的映射关系  
http://localhost:8080/actuator/mappings

8. /metrics/{requiredMetricName} GET  
统计程序的各种度量信息，如内存用量和请求数  
http://localhost:8080/actuator/metrics

9. /httptrace GET  
提供基本的http请求跟踪信息，如请求头等  
http://localhost:8080/actuator/httptrace  
请求404，可能是springboot版本太低

10. /threaddump GET  
获取线程活动的快照  
http://localhost:8080/actuator/threaddump  
请求404，可能是springboot版本太低

11. /conditions GET  
提供自动配置报告，记录哪些自动配置通过，哪些没有通过  
http://localhost:8080/actuator/conditions  
请求404，可能是springboot版本太低

12. /loggers/{name} GET  
查看日志配置信息  
http://localhost:8080/actuator/loggers

13. /auditevents GET  
查看系统发布的事件信息  
http://localhost:8080/actuator/auditevents

14. /caches/{cache} GET/DELETE  
查看系统的缓存管理器，另可根据缓存管理器名称查询；  
另DELETE操作可清除缓存  
http://localhost:8080/actuator/caches  
请求404，可能是springboot版本太低

15. /scheduledtasks GET  
查看系统发布的定时任务信息  
http://localhost:8080/actuator/scheduledtasks
请求404，可能是springboot版本太低

16. /features GET
查看Springcloud全家桶组件信息
http://localhost:8080/actuator/features  
请求404，可能是springboot版本太低

17. /refresh POST  
重启应用程序，慎用  
http://localhost:8080/actuator/refresh  
请求404，可能是springboot版本太低

18. /shutdown POST
关闭应用程序，慎用
http://localhost:8080/actuator/shutdown  
需要显示的配置，启动远程关闭功能

### 3.11boot-excel
excel文件导入及下载
1. excel导出 ip:port/exportUser

2. excel导入 ip:port/importUser

### 3.12spring-boot-cache
>以下模块，都是为了学习cache而存在  
spring-boot-cache  
spring-boot-cache-01  
spring-boot-cache-02  

springBoot整合连接mysql数据库和redis。  
使用@CacheConfig同步数据库和redis数据，减小数据库压力

### 3.13spring-boot-amqp
>以下模块，都是为了学习消息队列而存在  
spring-boot-amqp  
spring-boot-15

springBoot整和rabbitMq，实现基本的提供者生产消息，消费者处理消息

### 3.14spring-boot-dubbo
使用dubbo作为rpc远程通讯工具，实现消费者和提供者间的远程调用
* 提供者provider-ticket
* 消费者consumer-user

在com.hss.user.service.UserServiceTest.getTicket单元测试方法中，
测试远程方法调用。

### 3.15spring-boot-elastic
springBoot整合elasticSearch，实现索引创建、数据插入、数据查询

### 3.16spring-boot-starter
>以下模块，都是为了写自己的spring-boot-starter而存在  
spring-boot-starter，产出自定义的starter;
spring-boot-start，pom文件中引用并使用;

```xml
<dependency>
    <groupId>com.hss.starter</groupId>
    <artifactId>hss-spring-boot-starter</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

### 3.17spring-cloud
springCloud基本使用
* eureka-server，服务注册中心
* provider-ticket，服务的提供者
* consumer-user，服务的消费者

服务启动后，在consumer-user模块的com.hss.consumeruser.controller
.UserController.buyTicket方法中，可以测试远程调用。

### 3.18spring-boot-webservice
springBoot整合webservice，实现RPC远程调用。  
项目启动测试可以参考：spring-boot-webservice/help.md