package com.itcast.springboot.controller;

import com.itcast.springboot.dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class HelloController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/jdbcQuery")
    @ResponseBody
    public Map<String,Object> map(){
        log.info("------------>>jdbcQuery");
        List<Map<String, Object>> maps = userDao.findAll();
        return maps.get(0);
    }
}
