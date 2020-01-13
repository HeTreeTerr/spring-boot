package com.hss.springboot.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsynService {
    //异步处理,告诉springboot这是一个异步方法
    @Async
    public void hello() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("处理数据中。。。");
    }
}
