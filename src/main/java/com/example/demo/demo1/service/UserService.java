package com.example.demo.demo1.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.demo1.entities.User;
import com.example.demo.demo1.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService{
    @Resource
    UserMapper userMapper;

    public void run(String... args) throws Exception {
        List<User> users = userMapper.findAll();
        users.forEach(user -> System.out.println("User ID: " + user.getId() + ", Name: " + user.getName()));
    }

    public void addUser(User user) {
        userMapper.insertUser(user);
    }

    public void testPlus(User user) {

    }
}
