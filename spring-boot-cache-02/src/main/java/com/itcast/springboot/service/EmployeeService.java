package com.itcast.springboot.service;

import com.itcast.springboot.bean.Employee;
import com.itcast.springboot.mapper.EmployeeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

//以下的所有所有缓存注解可省去@CacheConfig的属性配置，抽取缓存的公共配置
/*属性：
    cacheNames
    keyGenerator
    cacheManager
    cacheResolver
*/
@Service
@CacheConfig(cacheNames = "emp")
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    //日志记录器
    Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 不加缓存时，每次查询都会调用sql数据库
     * @Cacheable注解，将方法的运行结果进行缓存
     * 以后再请求相同的数据，从缓存中获取，不用再调用数据库
     * CacheManager管理多个Cache组件，对缓存的真正CRUD操作在cache组件中，每一个缓存有自己唯一的一个名字
     * 属性：
     *      cacheNames/value:指定缓存的名字；数组格式，可指定多个
     *      key:缓存数据使用的key，可以用它来指定。默认使用参数的值
     *          编写SpEl表达式：
     *          #id，获取传参id
     *          #root.args[0],从根元素获取第一个参数
     *          #root.methodName+'['+#id+']'",getEmp[id]
     *      keyGenerator:key的生成器；可以自己指定key的生成器的组件id。如：keyGenerator = "keyGenerator"
     *           key/keyGenerator 二选一
     *      cacheManager：指定缓存管理器
     *      cacheResolver：缓存解析器；
     *          cacheManager/cacheResolver 二选一
     *      condition：判断条件，可以指定符合条件的情况下缓存
     *      unless: 除非，否定缓存；当unless为true,方法的返回值就不会被缓存；可以获取结果进行判断
     *      sync: 是否使用异步(不支持unless)
     *      @Cacheable(value = {"emp","temp"},key = "#id",condition = "#id > 0",unless = "#result == null")
     *
     * @param id
     * @return
     */
    @Cacheable(value = "emp"/*,keyGenerator = "keyGenerator",condition = "#a0 > 1",unless = "#a0 == 7"*/)
    public Employee getEmp(Integer id){
        log.info("-------->查询员工id={}",id);
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }
    /**
     * @CachePut,即调用方法，又更新缓存数据
     * 修改了数据库的某个数据，同时更新缓存；
     * 运行时机：
     * 1.先调用目标方法
     * 2.将目标方法的结果缓存起来
     * 测试步骤：
     * 1.先查询员工，再更新
     * 2.之后查询缓存中的内容
     * 3.更新员工信息
     * 4.查询员工，观察缓存是否更新
     *      没有，为什么？
     *      查询用key为id
     *      更新，讲方法的返回值放入缓存
     *      key:传入的employee对象  value:返回的employee对象
     *      因为key值不同，导致缓存更新不上
     *      统一key(@CachePut)值，即可
     *          key = "#employee.id"
     *          key = "#result.id"
     *      @Cacheable 不能使用#result
     */
    @CachePut(value = "emp",key = "#result.id")
    public Employee updateEmp(Employee employee){
        log.info("-------->员工更新方法调用employee={}",employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }
    /**
            * @CacheEvict: 缓存清理
     *key:指定要清除的数据，默认使用传参
     * @CacheEvict(value = "emp",key = "#id")
     * @CacheEvict(value = "emp",allEntries = true,beforeInvocation = true)
     *清除成功
     * 属性：
            *       allEntries:删除value属性下所有缓存，默认值为false
     *       beforeInvocation:是否在方法执行之前执行，默认值false
     *          beforeInvocation=false是，方法出现异常不会清空缓存.
     *          beforeInvocation = true,无论方法是否出现异常，都会清空缓存
     */
    @CacheEvict(value = "emp")
    public void deleteEmp(Integer id){
        log.info("-------->员工删除方法调用");
        //employeeMapper.deleteEmpById(id);
        //throw new RuntimeException("删除方法出错了");
    }

    /**
     *
     * @param lastName
     * @return
     *
     * @CachePut 表示方法一定要执行，从而将返回值写入缓存
     */
    @Caching(
            cacheable = {
                    @Cacheable(/*value = "emp",*/key = "#lastName")
            },
           /* put = {
                    @CachePut(value = "emp",key="#result.id"),
                    @CachePut(value = "emp",key = "#result.email")
            },*/
            evict = {
                    @CacheEvict(value = "emp",key = "#lastName")
            }
    )
    public Employee getEmpByLastName(String lastName){
        log.info("------------->由姓名查询员工");
        return employeeMapper.getEmpByLastName(lastName);
    }


}
