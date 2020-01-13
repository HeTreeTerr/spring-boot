package com.itcast.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping(value = "/success")
    public String success(Model model){
        model.addAttribute("message","你好");
        return "WEB-INF/success";
    }
}
