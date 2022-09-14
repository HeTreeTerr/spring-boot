package com.itcast.springboot.dao.impl;

import com.itcast.springboot.bean.User;
import com.itcast.springboot.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoImplTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void findAll() {
        List<Map<String, Object>> daoAll = userDao.findAll();
        if(!daoAll.isEmpty()){
            System.out.println(daoAll.get(0));
        }else {
            System.out.println("无相关数据！");
        }
    }

    @Test
    public void insert() {
        User user = new User();
        user.setId(4);
        user.setName("ww");
        userDao.insert(user);
        System.out.println("操作成功！");
    }
}