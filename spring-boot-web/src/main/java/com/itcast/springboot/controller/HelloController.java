package com.itcast.springboot.controller;

import com.itcast.springboot.dao.DepartmentDao;
import com.itcast.springboot.dao.EmployeeDao;
import com.itcast.springboot.entities.Department;
import com.itcast.springboot.entities.Employee;
import com.itcast.springboot.exception.UserNotExisException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

@Controller
public class HelloController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam(name = "user") String user){
        if(user.equals("aaa")){//user=aaa,抛出错误
            throw new UserNotExisException();
        }
        return "hello world";
    }

    //查出一些数据，在页面展示（thymeleaf）
    @RequestMapping(value = "/success")
    public String success(Map<String,Object> map){
        //实际查找地址：classpath:/templates/success.html
        map.put("hello","<h1>你好</h1>");
        map.put("users",Arrays.asList("<h2>TOM</h2>","二狗蛋","杰瑞"));
        return "success";
    }

//    @RequestMapping(value = {"/","/login.html"})
//    public String index(){
//        return "login";
//    }
    //查询所有用户
    @GetMapping(value = "/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        //放入request域中
        model.addAttribute("emplist",employees);
        return "emp/list";
    }
    //查询所有部门，进入添加页面
    @GetMapping("depts")
    public String toAddPage(Model model){
        //查询所有部门
        Collection<Department> departments = departmentDao.getDepartments();
        //将所有部门信息放入request域
        model.addAttribute("depts",departments);
        //来到添加员工页面
        return "emp/add";
    }
    //执行员工添加
    @PostMapping(value = "emp")
    public String addEmp(Employee employee){
        //System.out.println(employee);
        //添加
        employeeDao.save(employee);
        //添加成功返回员工列表界面
        //redirect:重定向
        //forword:转发 / 代表当前项目路径
        return "redirect:/emps";
    }
    //查询个人信息，进入修改页面
    @GetMapping(value = "/emp/{id}")
    public String toEditEmpPage(@PathVariable(name = "id") Integer id,Model model){
        //System.out.println(id);
        //查询所有部门
        Collection<Department> departments = departmentDao.getDepartments();
        //将所有部门信息放入request域
        model.addAttribute("depts",departments);
        //由id查询员工信息，进行数据回显
        Employee employee = employeeDao.get(id);
        //System.out.println(employee);
        model.addAttribute("emp",employee);
        return "emp/add";
    }
    //执行员工修改
    @PutMapping("/emp")
    public String updateEmp(Employee employee){
        //System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    //执行员工删除
    @DeleteMapping(value = "/emp/{id}")
    public String deleteEmp(@PathVariable(name = "id") Integer id){
        //System.out.println(id);
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
