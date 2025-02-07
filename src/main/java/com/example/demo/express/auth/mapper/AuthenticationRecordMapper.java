package com.example.demo.express.auth.mapper;


import com.example.demo.express.auth.entity.AuthenticationRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AuthenticationRecordMapper {
    int insert(@Param("record") AuthenticationRecord record);
    int deleteById(@Param("id") Long id);
    int update(@Param("record") AuthenticationRecord record);
    AuthenticationRecord selectById(@Param("id") Long id);
    List<AuthenticationRecord> selectPage(@Param("offset") int offset, 
                                        @Param("pageSize") int pageSize,
                                        @Param("name") String name,
                                        @Param("phoneNumber") String phoneNumber);
}
