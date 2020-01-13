package com.itcast.springboot.mapper;

import com.itcast.springboot.bean.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentMapperTest {
    @Autowired
    DepartmentMapper departmentMapper;

    @Test
    public void getDeptById() {
        Department department = departmentMapper.getDeptById(1);
        System.out.println(department);
    }

    @Test
    public void deleteDeptByid() {
    }

    @Test
    //@Transactional
    public void insertDept() {
        Department department = new Department();
        department.setDepartmentName("策划部");
        int result = departmentMapper.insertDept(department);
        System.out.println(result);
        //throw new RuntimeException("哎呀呀");
        //System.out.println(result);
    }

    @Test
    public void updateDept() {
    }
}