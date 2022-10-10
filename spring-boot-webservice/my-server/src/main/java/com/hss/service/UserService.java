package com.hss.service;

import com.hss.bean.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * 用户逻辑层
 */
@WebService(name = "UserService",targetNamespace = "http://service.hss.com")
public interface UserService {

    /**
     * 获取用户信息
     * @param name 用户名称
     * @return
     */
    @WebMethod
    String getUserName(@WebParam(name = "name")String name);
}
