package com.hss.service.impl;

import com.hss.bean.User;
import com.hss.service.UserService;
import lombok.extern.slf4j.Slf4j;

import javax.jws.WebService;

@WebService(
        serviceName = "UserService",
        targetNamespace = "http://service.hss.com",
        endpointInterface = "com.hss.service.UserService" // 指定webService的接口类，此类也需要接入@WebService注解
)
@Slf4j
public class UserServiceImpl implements UserService {

    @Override
    public String getUserName(String name) {
        User user = new User(name,18);
        log.info("user:{}",user);
        return name;
    }
}
