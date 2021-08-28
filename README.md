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
**注意：**项目打包会生成war包，实属无奈之举，不推荐使用。

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