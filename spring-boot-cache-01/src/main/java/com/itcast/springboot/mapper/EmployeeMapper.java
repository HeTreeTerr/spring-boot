package com.itcast.springboot.mapper;

import com.itcast.springboot.bean.Employee;
import org.apache.ibatis.annotations.*;

public interface EmployeeMapper {
    @Select(value = "select * from employee where id=#{id}")
    public Employee getEmpById(Integer id);
    @Update(value = "update employee set lastName=#{lastName},email=#{email},gender=#{gender},d_id=#{dId} where id=#{id}")
    public void updateEmp(Employee employee);
    @Delete(value = "delete from employee where id=#{id}")
    public void deleteEmpById(Integer id);
    @Insert(value = "insert into employee(lastName,email,gender,d_id) values(#{lastName},#{email},#{gender},#{dId})")
    public void insertEmp(Employee employee);
    @Select(value = "select * from employee where lastName=#{lastName}")
    public Employee getEmpByLastName(String lastName);
}
