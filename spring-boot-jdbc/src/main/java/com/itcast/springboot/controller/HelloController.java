package com.itcast.springboot.controller;

import com.itcast.springboot.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class HelloController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/jdbcQuery")
    @ResponseBody
    public Map<String,Object> map(){
        log.info("------------>>jdbcQuery");
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from tbl_user");
        return maps.get(0);
    }
}
