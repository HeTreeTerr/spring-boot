package com.itcast.springboot.controller;

import com.itcast.springboot.bean.Department;
import com.itcast.springboot.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {
    @Autowired
    DeptService deptService;
    /*
    缓存的数据可以存入，但查询缓存时，反序列化失败
    现阶段配置使用RedisTemplate<Object, Employee>操作redis解读数据

     */
    @GetMapping(value = "/dept/{id}")
    public Department getDeptById(@PathVariable(name = "id") Integer id){
        Department dept = deptService.getDeptById(id);
        return dept;
    }
}
