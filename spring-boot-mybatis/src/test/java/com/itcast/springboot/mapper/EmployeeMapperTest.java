package com.itcast.springboot.mapper;

import com.itcast.springboot.bean.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeMapperTest {
    @Autowired
    EmployeeMapper employeeMapper;
    @Test
    public void getEmpById() {

    }

    @Test
    //@Transactional
    public void insertEmp() {
        Employee emp = new Employee();
        emp.setLastName("何帅帅");
        emp.setEmail("123@qq.com");
        emp.setGender(1);
        emp.setdId(8);
        employeeMapper.insertEmp(emp);
        employeeMapper.insertEmp(emp);
        employeeMapper.insertEmp(emp);
        employeeMapper.insertEmp(emp);
    }
}