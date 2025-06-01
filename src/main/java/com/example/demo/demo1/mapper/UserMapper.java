package com.example.demo.demo1.mapper;

import com.example.demo.demo1.entities.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 用户数据访问层
 */
@Mapper
public interface UserMapper {
    
    /**
     * 查询所有用户
     */
    @Select("SELECT id, name FROM users")
    List<User> findAll();

    /**
     * 根据ID查询用户
     */
    @Select("SELECT id, name FROM users WHERE id = #{id}")
    User findById(@Param("id") Integer id);

    /**
     * 插入用户
     */
    @Insert("INSERT INTO users(name) VALUES(#{user.name})")
    @Options(useGeneratedKeys = true, keyProperty = "user.id")
    void insertUser(@Param("user") User user);

    /**
     * 更新用户
     */
    @Update("UPDATE users SET name = #{user.name} WHERE id = #{user.id}")
    void updateUser(@Param("user") User user);

    /**
     * 删除用户
     */
    @Delete("DELETE FROM users WHERE id = #{id}")
    void deleteById(@Param("id") Integer id);

    /**
     * 根据用户名查询用户数量（用于检查重复）
     */
    @Select("SELECT COUNT(*) FROM users WHERE name = #{name} AND id != #{excludeId}")
    int countByNameExcludeId(@Param("name") String name, @Param("excludeId") Integer excludeId);
}