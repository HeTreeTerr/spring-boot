package com.itcast.springboot.controller;

import com.itcast.springboot.bean.Employee;
import com.itcast.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {
    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping(value = "/emp/{id}")
    public Employee getEmp(@PathVariable(value = "id") Integer id){
        return employeeMapper.getEmpById(id);
    }
}
