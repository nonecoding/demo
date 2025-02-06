package com.example.demo.express.item.mapper;

import com.example.demo.express.item.entity.ExpressItemInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface ExpressItemInfoMapper {

    int insertExpressItemInfo(@Param("item") ExpressItemInfo item);

    int updateExpressItemInfo(@Param("item") ExpressItemInfo item);

    int deleteExpressItemInfoById(@Param("id") Integer id);

    ExpressItemInfo selectExpressItemInfoById(@Param("id") Integer id);

    List<ExpressItemInfo> selectExpressItemInfoPage(@Param("offset") int offset, @Param("limit") int limit);
}
