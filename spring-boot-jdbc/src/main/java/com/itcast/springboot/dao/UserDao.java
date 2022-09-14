package com.itcast.springboot.dao;

import com.itcast.springboot.bean.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    List<Map<String, Object>> findAll();

    void insert(User user);
}
