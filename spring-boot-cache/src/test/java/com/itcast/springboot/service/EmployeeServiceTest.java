package com.itcast.springboot.service;

import com.itcast.springboot.bean.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {
    @Autowired
    private EmployeeService employeeService;

    @Test
    public void getEmp() {
        Employee emp = employeeService.getEmp(1);
        System.out.println(emp);
    }
    @Test
    public void updateEmp(){
        //查询
        Employee emp = employeeService.getEmp(11);
        //修改
        emp.setGender(0);
        Employee emp1 = employeeService.updateEmp(emp);
        System.out.println(emp1);
        //测试值不为null,不然报错
        Assert.assertNotNull(emp1);
    }
}