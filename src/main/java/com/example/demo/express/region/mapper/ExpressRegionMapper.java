package com.example.demo.express.region.mapper;

import com.example.demo.express.region.entity.ExpressRegion;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xj
 * @since 2025-02-06
 */
@Mapper
public interface ExpressRegionMapper{

    List<ExpressRegion> findAll();

}
