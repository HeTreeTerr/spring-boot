package com.hss.springboot.controller;

import com.hss.springboot.service.AsynService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {
    @Autowired
    AsynService asynService;
    @GetMapping(value = "/hello")
    public String hello() throws InterruptedException {
        asynService.hello();
        return "success";
    }
}
