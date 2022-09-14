package com.itcast.springboot.dao.impl;

import com.itcast.springboot.bean.User;
import com.itcast.springboot.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> findAll() {
        return jdbcTemplate.queryForList("select * from tbl_user");
    }

    @Transactional
    @Override
    public void insert(User user) {
        String sql = "insert into `tbl_user`(id,name) values(?,?)";
        jdbcTemplate.update(sql,user.getId(),user.getName());
        //自定义异常
        if(true){
            throw new RuntimeException("hss 运行时异常！");
        }
    }
}
