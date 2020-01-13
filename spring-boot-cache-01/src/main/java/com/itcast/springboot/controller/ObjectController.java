package com.itcast.springboot.controller;

import com.itcast.springboot.service.ObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ObjectController {
    @Autowired
    ObjectService objectService;

    @GetMapping(value = "getObject/{id}")
    public Map<Object,Object> getObjectCache(@PathVariable(name = "id") Integer id){
        Map<Object,Object> map = objectService.getObject(id);
        return map;
    }
}
