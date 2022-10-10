package com.hss.wsdl;

import com.hss.utils.ClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserServiceTest {

    /**
     * 在一个方法中连续调用多次WebService接口，每次调用前需要重置上下文。
     */
    private static final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

    @Test
    public void getUserName() {
        //在获取连接之前 还原上下文
        Thread.currentThread().setContextClassLoader(classLoader);

        String url = "http://localhost:8001/ws/user?wsdl";
        String methodName = "getUserName";
        String params = "hss";
        try {
            String res = ClientUtil.callWebSV(url, methodName, params);
            log.info("res:{}",res);

            String res1 = ClientUtil.callWebSV(url, methodName, params);
            log.info("res1:{}",res1);
        } catch (Exception e) {
            log.error("调用失败：",e);
        }
    }
}