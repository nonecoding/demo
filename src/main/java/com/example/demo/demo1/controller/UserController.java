package com.example.demo.demo1.controller;


import com.example.demo.demo1.entities.User;
import com.example.demo.demo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// 标记为控制器
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    // 创建一个GET端点
    @GetMapping("/run")
    public String run() {
        try {
            userService.run();
            return "Service executed successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error executing service: " + e.getMessage();
        }
    }

    // 创建一个POST端点来插入数据
    @PostMapping("/user")
    public String addUser(@RequestBody User user) {
        userService.addUser(user);
        return "User added successfully";
    }

    @PostMapping("/testPlus")
    public String testPlus(@RequestBody User user) {
        userService.testPlus(user);
        return "User added successfully";
    }


}