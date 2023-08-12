package com.hss.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MyWebServiceConfigTest {

    @Autowired
    private MyWebServiceConfig myWebServiceConfig;

    @Test
    public void loadConfig(){
        log.info("info1:{}",myWebServiceConfig.getWebserviceUrl());
        log.info("info2:{}",myWebServiceConfig.getGetUserNameMethodName());
    }
}