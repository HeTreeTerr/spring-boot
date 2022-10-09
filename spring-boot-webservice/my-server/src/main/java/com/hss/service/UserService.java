package com.hss.service;

import com.hss.bean.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * 用户逻辑层
 */
@WebService(targetNamespace = "service.hss.com",name = "userPortType")
public interface UserService {

    /**
     * 获取用户信息
     * @param name 用户名称
     * @return
     */
    @WebMethod
    User getUserName(@WebParam(name = "name")String name);
}
