package com.example.demo.express.order.mapper;

import com.example.demo.express.order.entity.ExpressOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ExpressOrderMapper {

    int insert(@Param("order") ExpressOrder order);

    int update(@Param("order") ExpressOrder order);

    int deleteById(@Param("id") Integer id);

    ExpressOrder selectById(@Param("id") Integer id);

    List<ExpressOrder> selectPage(@Param("offset") int offset, @Param("size") int size);
}
