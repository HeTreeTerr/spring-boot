package com.hss.wsdl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserPortTypeTest {

    @Resource(name = "cxfProxy")
    private UserPortType userPortType;

    @Test
    public void getUserName() {
        User userName = userPortType.getUserName("张三");
        log.info("userName:{}",userName);
    }
}