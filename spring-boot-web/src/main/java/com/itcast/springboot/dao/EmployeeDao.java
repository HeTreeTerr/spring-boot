package com.itcast.springboot.dao;

import com.itcast.springboot.entities.Department;
import com.itcast.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EmployeeDao {
    //新建Map集合
    private static Map<Integer,Employee> employees = null;
    //注入部门Dao
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer, Employee>();

        employees.put(1001,new Employee(1001,"A-A","123@qq.com",1,new Department(101,"B-A"),new Date()));
        employees.put(1002,new Employee(1002,"A-B","123@qq.com",0,new Department(102,"B-B"),null));
        employees.put(1003,new Employee(1003,"A-C","123@qq.com",0,new Department(103,"B-C"),null));
        employees.put(1004,new Employee(1004,"A-D","123@qq.com",1,new Department(104,"B-D"),null));
        employees.put(1005,new Employee(1005,"A-E","123@qq.com",0,new Department(105,"B-E"),null));
    }
    private static Integer initId = 1006;
    //添加员工
    public void save(Employee employee){
        if(employee.getId() == null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }
    //查询所有员工
    public Collection<Employee> getAll(){
        return employees.values();
    }
    //由id查询
    public Employee get(Integer id){
        return employees.get(id);
    }
    //由id删除
    public void delete(Integer id){
        employees.remove(id);
    }
}
