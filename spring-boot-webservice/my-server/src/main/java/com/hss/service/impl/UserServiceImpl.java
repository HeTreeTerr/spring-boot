package com.hss.service.impl;

import com.hss.bean.User;
import com.hss.service.UserService;
import javax.jws.WebService;

@WebService(
        targetNamespace = "service.hss.com", //命名空间 指定wsdl
        name = "userPortType",
        serviceName = "userService", //服务Name名称
        portName = "userPortName",
        endpointInterface = "com.hss.service.UserService" // 指定webService的接口类，此类也需要接入@WebService注解
)
public class UserServiceImpl implements UserService {

    @Override
    public User getUserName(String name) {
        User user = new User("hss",18);
        return user;
    }
}
