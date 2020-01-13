package com.itcast.springboot.controller;

import com.itcast.springboot.bean.Department;
import com.itcast.springboot.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DeptController {
    @Autowired
    DepartmentMapper departmentMapper;

    @GetMapping("/dept/{id}")
    public Department getDept(@PathVariable(name = "id") Integer id){

        return departmentMapper.getDeptById(id);
    }
    @GetMapping("/dept")
    //@Transactional
    public Department addDept(@Valid Department department, BindingResult result){
        System.out.println("jsr303效验");
        if(result.hasErrors()) {
            //校验失败
            Map<String ,Object> map = new HashMap<>();
            List<FieldError> errors= result.getFieldErrors();
            for(FieldError fieldError : errors) {
                System.out.println(fieldError.getField());
                System.out.println(fieldError.getDefaultMessage());
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }

        }else {
            System.out.println("6562359896"+department);

        }
        departmentMapper.insertDept(department);
//事务管理测试
//        departmentMapper.insertDept(department);
//        if(department.getDepartmentName().equals("EE")){
//            throw new RuntimeException("运行时异常，回滚");
//        }
        return department;
    }
}
