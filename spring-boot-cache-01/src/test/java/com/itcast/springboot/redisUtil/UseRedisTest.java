package com.itcast.springboot.redisUtil;

import com.itcast.springboot.bean.Employee;
import com.itcast.springboot.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UseRedisTest {
    /*
    springboot封装Redis
     */
    //操作：key-value都是Object
    @Autowired
    RedisTemplate redisTemplate;
    //S操作字符串：k-v都是tring
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    RedisTemplate<Object, Employee> empRedisTemplate;
    @Autowired
    RedisTemplate<Object, Object> objectRedisTemplate;
    /**
     * Redis常见的五大数据类型
     * String(字符串)，List(列表)，set(集合),hash(散列),Zset(有序集合)
     * stringRedisTemplate.opsForValue()[String(字符串)]
     * stringRedisTemplate.opsForList()[List(列表)]
     * ...
     */
    @Test
    public void test01(){
        //向redis中保存数据msg=hello
        //stringRedisTemplate.opsForValue().append("msg","hello");
        //从redis中读取数据
//        String msg = stringRedisTemplate.opsForValue().get("msg");
//        System.out.println("----------->msg="+msg);
        //向list中放值
//        stringRedisTemplate.opsForList().leftPush("mylist","1");

    }
    @Test
    public void test2(){
        Employee emp = employeeService.getEmp(11);
        //默认如果保存对象，使用jdk序列化机制，序列化后的数据保存到redis中。优点乱
        //redisTemplate.opsForValue().set(emp.getId(),emp);
        //将数据以json的格式保存
        empRedisTemplate.opsForValue().set("emp-11",emp);
    }
//测试 RedisTemplate<Object, Object> objectRedisTemplate 方法
    @Test
    public void test3(){
       /* Map<Object,Object> map = new HashMap<>();
        map.put("1","一");
        map.put("2","二");
        map.put("3","三");
        objectRedisTemplate.opsForValue().set("map",map);*/

    }
}
