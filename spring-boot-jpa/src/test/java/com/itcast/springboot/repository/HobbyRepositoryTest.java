package com.itcast.springboot.repository;

import com.itcast.springboot.entity.Hobby;
import com.itcast.springboot.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HobbyRepositoryTest {

    @Autowired
    private HobbyRepository hobbyRepository;

    /**
     * 新增
     */
    @Test
    public void save(){
        Hobby hobby = new Hobby();
        hobby.setHobbyName("乒乓");
        hobby.setUser(new User(17));

        Hobby resHobby = hobbyRepository.save(hobby);
        System.out.println(resHobby);
    }

    /**
     * 修改
     */
    @Test
    public void update(){
        Hobby hobby = new Hobby();
        hobby.setId(1);
        hobby.setHobbyName("乒乓");
        hobby.setUser(new User(15));

        Hobby resHobby = hobbyRepository.save(hobby);
        System.out.println(resHobby);
    }

    /**
     * 删除
     */
    @Test
    public void delete(){
        hobbyRepository.deleteById(1);
        System.out.println("------删除成功-----");
    }

    /**
     * 列表查询
     */
    @Test
    public void queryList(){
        List<Hobby> hobbyList = hobbyRepository.findAll();
        for(Hobby hobby : hobbyList){
            System.out.println(hobby);
        }
    }
}