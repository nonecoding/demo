package com.example.demo.express.mapper;

import com.example.demo.express.entity.ExpressAddress;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xj
 * @since 2025-02-05
 */
@Mapper
public interface ExpressAddressMapper{

    int insert(@Param("address") ExpressAddress address);
    int deleteById(@Param("id") Integer id);
    int update(@Param("address") ExpressAddress address);
    ExpressAddress selectById(@Param("id") Integer id);
    List<ExpressAddress> selectPage(@Param("offset") int offset, @Param("pageSize") int pageSize);
    int countAll();

}
