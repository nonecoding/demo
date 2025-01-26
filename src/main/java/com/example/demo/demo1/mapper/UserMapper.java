package com.example.demo.demo1.mapper;



import com.example.demo.demo1.entities.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
//    @Select("SELECT * FROM USERS")
    List<User> findAll();

    // 定义插入方法
//    @Insert("insert into USERS(NAME) values(#{user.name})")
    void insertUser(@Param("user") User user);

    User findById(@Param("id") int id);
}