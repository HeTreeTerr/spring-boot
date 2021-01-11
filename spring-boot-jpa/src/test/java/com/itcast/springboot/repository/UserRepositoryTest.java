package com.itcast.springboot.repository;

import com.itcast.springboot.entity.User;
import com.itcast.springboot.enums.SexEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    /**
     * 统计
     */
    @Test
    public void count(){
        //select count(*) as col_0_0_ from tbl_user user0_
        /*Long count = userRepository.count();*/

        //select count(user0_.id) as col_0_0_ from tbl_user user0_ where user0_.last_name=?
        /*User user = new User();
        user.setLastName("hss");
        Example<User> example = Example.of(user);
        long count = userRepository.count(example);*/

        //select count(user0_.id) as col_0_0_ from tbl_user user0_ where user0_.email like ?
        User user = new User();
        user.setEmail("3110708879@qq.com");
        ExampleMatcher exampleMatcher = ExampleMatcher.matching();
        //原写法
        exampleMatcher = exampleMatcher.withMatcher("email", ExampleMatcher.GenericPropertyMatchers.contains());
        //简化版写法
        //exampleMatcher.withMatcher("email",math -> math.contains());
        // user 指定需要比对的值  exampleMatcher 指定比对的规则
        Example<User> example = Example.of(user,exampleMatcher);
        long count = userRepository.count(example);

        System.out.println(count);
    }

    /**
     * 存在
     */
    @Test
    public void exists(){
        //select count(*) as col_0_0_ from tbl_user user0_ where user0_.id=?
        /*boolean exists = userRepository.existsById(1);*/

        //select user0_.id as id1_0_, user0_.birthday as birthday2_0_, user0_.email as email3_0_, user0_.last_name as last_nam4_0_, user0_.sex as sex5_0_ from tbl_user user0_ where user0_.email=?
        /*User user = new User();
        user.setEmail("3110708879@qq.com1");
        Example<User> example = Example.of(user);
        boolean exists = userRepository.exists(example);*/

        //select user0_.id as id1_0_, user0_.birthday as birthday2_0_, user0_.email as email3_0_, user0_.last_name as last_nam4_0_, user0_.sex as sex5_0_ from tbl_user user0_ where user0_.last_name=? and (user0_.email like ?)
        User user = new User();
        user.setEmail("3110708879@qq.com");
        user.setLastName("hss");
        user.setSex(SexEnum.男);
        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny();
        //原写法
        exampleMatcher = exampleMatcher.withMatcher("email", ExampleMatcher.GenericPropertyMatchers.contains());

        Example<User> example = Example.of(user,exampleMatcher);
        boolean exists = userRepository.exists(example);
        System.out.println(exists);
    }

    @Test
    public void findUsersByLastNameIsStartingWithAndEmailContains(){
        String name = "ss";
        String email = "3110708879@qq.com";
        //List<User> users = userRepository.findUsersByLastNameIsStartingWithAndEmailContains(name, email);
        //List<User> users = userRepository.findUsersByLastNameIsStartingWith(name);
        List<User> users = userRepository.findUsersByLastNameIsEndingWith(name);
        System.out.println(users);
    }

}