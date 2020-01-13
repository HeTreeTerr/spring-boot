package com.itcast.springboot.dao;

import com.itcast.springboot.entities.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentDaoTest {
    @Autowired
    private DepartmentDao departmentDao;
    @Test
    public void getDepartments() {
        Collection<Department> departments = departmentDao.getDepartments();
        //System.out.println(departments);
        for (Department dept: departments) {
            System.out.println(dept);
        }
    }

    @Test
    public void getDepartment() {
        Department dept = departmentDao.getDepartment(101);
        System.out.println(dept);
    }
}