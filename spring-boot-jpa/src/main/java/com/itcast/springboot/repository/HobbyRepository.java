package com.itcast.springboot.repository;

import com.itcast.springboot.entity.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Hobby
 * 继承JpaRepository来完成对数据库的操作
 */
public interface HobbyRepository extends JpaRepository<Hobby,Integer> {

}
