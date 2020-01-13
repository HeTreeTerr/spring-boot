package com.itcast.springboot.mapper;

import com.itcast.springboot.bean.Employee;

//无论是注解还是配置文件的Mapper,都需要@Mapper注解，或@Mapper批量扫描
public interface EmployeeMapper {
    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);
}
