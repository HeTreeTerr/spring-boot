package com.itcast.springboot.mapper;

import com.itcast.springboot.bean.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeMapperTest {

    @Autowired
    private EmployeeMapper mapper;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void getEmpById() {
        Employee emp = mapper.getEmpById(1);
        logger.info("--------->emp={}",emp);
        Assert.assertNotNull(emp);
    }

    @Test
    public void updateEmp() {
        //先查询
        Employee emp = mapper.getEmpById(1);
        //修改属性gender
        emp.setGender(0);
        mapper.updateEmp(emp);

    }

    @Test
    public void deleteEmpById() {
        mapper.deleteEmpById(10);
    }

    @Test
    public void insertEmp() {
        Employee emp = new Employee();
        emp.setLastName("何小二");
        emp.setEmail("123@qq.com");
        emp.setGender(1);
        emp.setdId(9);
        mapper.insertEmp(emp);
    }

    @Test
    public void getEmpByLastName(){
        String lastName = "何小二";
        Employee emp = mapper.getEmpByLastName(lastName);
        logger.info("------------>employee={}",emp);
        Assert.assertEquals(lastName,emp.getLastName());
    }
}