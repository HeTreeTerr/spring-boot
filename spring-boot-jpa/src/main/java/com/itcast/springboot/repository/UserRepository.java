package com.itcast.springboot.repository;

import com.itcast.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//继承JpaRepository来完成对数据库的操作
public interface UserRepository extends JpaRepository<User,Integer> {



    List<User> findUsersByLastNameIsStartingWithAndEmailContains(String lastName,String email);

    List<User> findUsersByLastNameIsStartingWith(String lastName);

    List<User> findUsersByLastNameIsEndingWith(String lastName);

    @Modifying
    @Query("update User u set u.email=?2 where  u.id=?1")
    void updateEmailByUserId(Integer userId, String email);


}
