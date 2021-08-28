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

## 3.7spring-boot-security
springBoot整合springSecurity安全框架，实现用户权限管理。
1. 在com.itcast.springboot.config.MySecurityConfig中，定义三个用户（hss、
hww、lll），定义三个角色（VIP1、VIP2、VIP3）。指定用户和角色的关系，指定接口url
和角色的关系。
2. 访问http://localhost:8080/，分别使用不同的用户登录系统，实现不同角色用户，
分配不同权限。