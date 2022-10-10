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

    @Test
    public void getUserName() {
        String url = "http://localhost:8001/ws/user?wsdl";
        String methodName = "getUserName";
        String params = "hss";

        try {
            String res = ClientUtil.callWebSV(url, methodName, params);
            log.info("res:{}",res);
        } catch (Exception e) {
            log.error("调用失败：",e);
        }
    }
}