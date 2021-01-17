package com.itcast.springboot.repository;

import com.itcast.springboot.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 继承JpaRepository来完成对数据库的操作
 */
public interface UserRepository extends JpaRepository<User,Integer> {


    Page<User> findAll(Specification<User> userSpecification, Pageable pageable);

    List<User> findUsersByLastNameIsStartingWithAndEmailContains(String lastName,String email);

    List<User> findUsersByLastNameIsStartingWith(String lastName);

    List<User> findUsersByLastNameIsEndingWith(String lastName);

    /**
     * 表名不要写数据库中的值,使用entity的类名
     * 属性名也同样不要使用数据库值，使用entity的属性名
     * @param userId
     * @param email
     */
    @Modifying
    @Query("update User u set u.email=?2, u.lastName=?3 where  u.id=?1")
    void updateEmailByUserId(Integer userId, String email, String lastName);

    @Query("select id,lastName,email,sex,birthday from User where id=?1")
    List<User> findUserById(Integer id);
}
