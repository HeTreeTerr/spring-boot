package com.itcast.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    private final String PREFIX = "page/";
    //欢迎页
    @GetMapping(value = "/")
    public String hello(){
        return "welcome";
    }
    //登录页
    @GetMapping(value = "/userlogin")
    public String loginPage(){
        return PREFIX+"login";
    }
    //普通武功模块
    @GetMapping(value = "/level1/{path}")
    public String level1(@PathVariable(name = "path") String path){
        return PREFIX+"level1/"+path;
    }
    //高级武功模块
    @GetMapping(value = "/level2/{path}")
    public String level2(@PathVariable(name = "path") String path){
        return PREFIX+"level2/"+path;
    }

    @GetMapping(value = "/level3/{path}")
    public String level3(@PathVariable(name = "path") String path){
        return PREFIX+"level3/"+path;
    }

}
