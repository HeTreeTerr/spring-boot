package com.itcast.springboot.mapper;

import com.itcast.springboot.bean.Department;
import org.apache.ibatis.annotations.Select;

public interface DepartmentMapper {
    @Select(value = "select * from department where id=#{id}")
    Department getDeptById(Integer id);
}
