package com.itcast.springboot.controller;

import com.itcast.springboot.bean.Employee;
import com.itcast.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/emp/{id}")
    public Employee getEmployee(@PathVariable(name = "id") Integer id){
        Employee emp = employeeService.getEmp(id);
        return emp;
    }
    //rest风格修改put请求
    @GetMapping(value = "/emp")
    public Employee update(Employee employee){
        Employee emp = employeeService.updateEmp(employee);
        return emp;
    }
    @GetMapping(value = "/delemp")
    public String delete(Integer id){
        employeeService.deleteEmp(id);
        return "delete emp success";
    }
    @GetMapping(value = "/emp/lastname/{lastName}")
    public Employee getEmpByLastName(@PathVariable(name = "lastName") String lastName){
        Employee empByLastName = employeeService.getEmpByLastName(lastName);
        return empByLastName;
    }
}
