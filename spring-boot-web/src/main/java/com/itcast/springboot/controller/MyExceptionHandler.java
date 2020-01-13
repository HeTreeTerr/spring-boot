package com.itcast.springboot.controller;

import com.itcast.springboot.exception.UserNotExisException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 异常处理器
 * @ControllerAdvice
 * 注解将不起作用
 */
@ControllerAdvice
public class MyExceptionHandler {
    //浏览器和客户端都返回json数据
//    @ResponseBody
//    @ExceptionHandler(UserNotExisException.class)
//    public Map<String,Object> handleException(Exception e){
//        Map<String,Object> map = new HashMap<>();
//        map.put("code","user.notexist");
//        map.put("message",e.getMessage());
//        return map;
//    }
    //Controller层抛出异常的异常处理器
    @ExceptionHandler(UserNotExisException.class)
    public String handleException(Exception e, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        //需要自己的状态码
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        //将页面报错信息放入request域中
        request.setAttribute("ext",map);
        //转发到error
        return "forward:/error";
    }

}
