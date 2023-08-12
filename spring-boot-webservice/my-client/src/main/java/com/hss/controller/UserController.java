package com.hss.controller;

import com.hss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 心灯一盏
 * </p>
 *
 * @author Hss
 * @date 2023-08-12
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户名
     * @param name
     * @return
     */
    @GetMapping(value = "/getUserName")
    public String getUserName(@RequestParam(value = "name") String name){

        return userService.getUserName(name);
    }
}
