package com.itcast.springboot.mapper;

import com.itcast.springboot.bean.Department;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentMapperTest {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Test
    public void getDeptById() {
        Integer id = 1;
        Department dept = departmentMapper.getDeptById(id);
        System.out.println(dept);
        Assert.assertEquals(id,dept.getId());
    }
}