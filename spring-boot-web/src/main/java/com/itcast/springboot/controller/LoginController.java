package com.itcast.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping(value = "/user/login")
    public String login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password,
                        Map<String,Object> map, HttpSession session){
        //System.out.println(username+"--------"+password);
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            session.setAttribute("loginUser",username);
            //登录成功,为防止表单重复提交重定向
            return "redirect:/main.html";
        }else{
            //登录失败
            map.put("msg","用户名密码错误");
            return "login";
        }

    }
    @GetMapping(value = "/user/signOut")
    public String signOut(HttpSession session){
        //销毁session执行退出
        session.invalidate();
        return "redirect:/index.html";
    }
}
