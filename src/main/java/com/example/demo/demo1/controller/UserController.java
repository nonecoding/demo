package com.example.demo.demo1.controller;

import com.example.demo.common.response.ApiResponse;
import com.example.demo.demo1.entities.User;
import com.example.demo.demo1.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

/**
 * 用户管理控制器
 */
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Slf4j
@Validated
@Api(tags = "用户管理")
public class UserController {

    private final UserService userService;

    @GetMapping("/list")
    @ApiOperation("获取所有用户列表")
    public ApiResponse<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ApiResponse.success("获取用户列表成功", users);
    }

    @PostMapping
    @ApiOperation("创建新用户")
    public ApiResponse<Void> createUser(@Valid @RequestBody User user) {
        userService.createUser(user);
        return ApiResponse.success("用户创建成功", null);
    }

    @GetMapping("/{id}")
    @ApiOperation("根据ID获取用户信息")
    public ApiResponse<User> getUserById(
            @ApiParam(value = "用户ID", required = true)
            @PathVariable @Positive(message = "用户ID必须为正数") Integer id) {
        User user = userService.getUserById(id);
        return ApiResponse.success("获取用户信息成功", user);
    }

    @PutMapping("/{id}")
    @ApiOperation("更新用户信息")
    public ApiResponse<Void> updateUser(
            @ApiParam(value = "用户ID", required = true)
            @PathVariable @Positive(message = "用户ID必须为正数") Integer id,
            @Valid @RequestBody User user) {
        user.setId(id);
        userService.updateUser(user);
        return ApiResponse.success("用户更新成功", null);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除用户")
    public ApiResponse<Void> deleteUser(
            @ApiParam(value = "用户ID", required = true)
            @PathVariable @Positive(message = "用户ID必须为正数") Integer id) {
        userService.deleteUser(id);
        return ApiResponse.success("用户删除成功", null);
    }
}