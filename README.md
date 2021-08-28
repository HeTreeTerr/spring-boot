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
### 3.1 spring-boot-jsp
如果历史ssm项目想升级使用springBoot，但是有jsp页面等历史包袱，全部升级重写代价太大。  
可以在springBoot项目中使用外置的tomcat，以此达到在同一微服务中同时使用springBoot
和jsp的目的。  
**注意：**项目打包会生成war包，实属无奈之举，不推荐使用。

### 3.2 spring-boot-jdbc
springBoot整合druid数据源，通过JdbcTemplate工具类实现mysql数据库链接。