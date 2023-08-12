package com.hss.service.impl;

import com.hss.config.MyWebServiceConfig;
import com.hss.service.UserService;
import com.hss.utils.ClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * </p>
 *
 * @author Hss
 * @date 2023-08-12
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    /**
     * 在一个方法中连续调用多次WebService接口，每次调用前需要重置上下文。
     */
    private static final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

    @Autowired
    private MyWebServiceConfig myWebServiceConfig;

    @Override
    public String getUserName(String userName) {
        //在获取连接之前 还原上下文
        Thread.currentThread().setContextClassLoader(classLoader);

        String url = myWebServiceConfig.getWebserviceUrl();
        String methodName = myWebServiceConfig.getGetUserNameMethodName();
        String params = userName;
        try {
            String res = ClientUtil.callWebSV(url, methodName, params);
            log.info("res:{}",res);
            return res;
        } catch (Exception e) {
            log.error("调用失败：",e);
        }
        return "CODE:500,MSG:FAIL";
    }
}
