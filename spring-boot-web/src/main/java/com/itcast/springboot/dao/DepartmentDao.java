package com.itcast.springboot.dao;

import com.itcast.springboot.entities.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {
    private static Map<Integer,Department> departments = null;

    static {
        departments = new HashMap<Integer, Department>();

        departments.put(101,new Department(101,"B-A"));
        departments.put(102,new Department(102,"B-B"));
        departments.put(103,new Department(103,"B-C"));
        departments.put(104,new Department(104,"B-D"));
        departments.put(105,new Department(105,"B-E"));
    }
    //查询所有部门
    public Collection<Department> getDepartments(){
        return departments.values();
    }
    //由ID查询单个部门
    public Department getDepartment(Integer id){
        return departments.get(id);
    }
}
