package com.example.demo.demo1.service;

import com.example.demo.common.exception.BusinessException;
import com.example.demo.demo1.entities.User;
import com.example.demo.demo1.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

/**
 * 用户服务类
 */
@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class UserService {
    
    private final UserMapper userMapper;

    /**
     * 获取所有用户
     */
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        try {
            List<User> users = userMapper.findAll();
            log.info("Successfully retrieved {} users", users.size());
            return users;
        } catch (Exception e) {
            log.error("Failed to retrieve users", e);
            throw new BusinessException("获取用户列表失败");
        }
    }

    /**
     * 创建用户
     */
    public void createUser(User user) {
        validateUser(user);
        
        try {
            userMapper.insertUser(user);
            log.info("Successfully created user: {}", user.getName());
        } catch (Exception e) {
            log.error("Failed to create user: {}", user.getName(), e);
            throw new BusinessException("创建用户失败");
        }
    }

    /**
     * 根据ID获取用户
     */
    @Transactional(readOnly = true)
    public User getUserById(Integer id) {
        if (id == null || id <= 0) {
            throw new BusinessException("用户ID无效");
        }
        
        try {
            User user = userMapper.findById(id);
            if (user == null) {
                throw new BusinessException("用户不存在");
            }
            log.info("Successfully retrieved user: {}", user.getName());
            return user;
        } catch (BusinessException e) {
            throw e;
        } catch (Exception e) {
            log.error("Failed to retrieve user with id: {}", id, e);
            throw new BusinessException("获取用户信息失败");
        }
    }

    /**
     * 更新用户
     */
    public void updateUser(User user) {
        if (user.getId() == null || user.getId() <= 0) {
            throw new BusinessException("用户ID无效");
        }
        
        validateUser(user);
        
        // 检查用户是否存在
        User existingUser = getUserById(user.getId());
        if (existingUser == null) {
            throw new BusinessException("用户不存在");
        }
        
        try {
            userMapper.updateUser(user);
            log.info("Successfully updated user: {}", user.getName());
        } catch (Exception e) {
            log.error("Failed to update user: {}", user.getName(), e);
            throw new BusinessException("更新用户失败");
        }
    }

    /**
     * 删除用户
     */
    public void deleteUser(Integer id) {
        if (id == null || id <= 0) {
            throw new BusinessException("用户ID无效");
        }
        
        // 检查用户是否存在
        User existingUser = getUserById(id);
        if (existingUser == null) {
            throw new BusinessException("用户不存在");
        }
        
        try {
            userMapper.deleteById(id);
            log.info("Successfully deleted user with id: {}", id);
        } catch (Exception e) {
            log.error("Failed to delete user with id: {}", id, e);
            throw new BusinessException("删除用户失败");
        }
    }

    /**
     * 验证用户数据
     */
    private void validateUser(User user) {
        if (user == null) {
            throw new BusinessException("用户信息不能为空");
        }
        
        if (!StringUtils.hasText(user.getName())) {
            throw new BusinessException("用户名不能为空");
        }
        
        if (user.getName().trim().length() < 2 || user.getName().trim().length() > 50) {
            throw new BusinessException("用户名长度必须在2-50个字符之间");
        }
    }
}
