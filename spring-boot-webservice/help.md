# spring-boot-webservice
> 参考博客   
> 基础搭建：https://blog.csdn.net/qq_43842093/article/details/123076587  
> bug解决：https://blog.csdn.net/xuming9/article/details/78127354?spm=1001.2101.3001.6650.7&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7ERate-7-78127354-blog-106682506.pc_relevant_multi_platform_whitelistv3&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7ERate-7-78127354-blog-106682506.pc_relevant_multi_platform_whitelistv3&utm_relevant_index=8

## 1 子模块介绍
* my-server(服务提供模块)
* my-client(服务消费模块)

## 2 子模块启动和测试
### 2.1 my-server
选择主类启动，启动成功后在浏览器访问：  
http://localhost:8001/ws/user?wsdl

### 2.2 my-client
调用单元测试，确认通讯
com.hss.wsdl.UserServiceTest#getUserName
访问URL，确认通讯
http://localhost:8080/getUserName?name=hss