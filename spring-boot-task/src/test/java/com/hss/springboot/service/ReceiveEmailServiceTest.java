package com.hss.springboot.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReceiveEmailServiceTest {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ReceiveEmailService receiveEmailService;

    @Test
    public void receiveEmail() {
        receiveEmailService.receiveEmail();
        log.info("操作成功！");
    }
}