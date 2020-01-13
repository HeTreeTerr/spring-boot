package com.itcast.springboot.controller;

import com.itcast.springboot.entity.User;
import com.itcast.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/user/{id}")
    public Optional<User> getUser(@PathVariable(name = "id") Integer id){

        Optional<User> byId = userRepository.findById(id);
        return byId;
    }
    @GetMapping(value = "/user")
    public User insertUser(User user){
        User user1 = userRepository.save(user);
        return user1;
    }
}
