package com.example.demo.express.region.service;

import com.example.demo.express.region.entity.ExpressRegion;
import com.example.demo.express.region.mapper.ExpressRegionMapper;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xj
 * @since 2025-02-06
 */
@Service
public class ExpressRegionServiceImpl{

    @Autowired
    private ExpressRegionMapper regionMapper;

    public List<ExpressRegion> getRegionTree() {
        // 读取所有区域数据，例如先从数据库查询出来
        List<ExpressRegion> allRegions = regionMapper.findAll();
        // 分组：按照 parentId 作为 key
        Map<Integer, List<ExpressRegion>> groupByParent = allRegions.stream()
                .filter(region -> region.getParentId() != null)
                .collect(Collectors.groupingBy(ExpressRegion::getParentId));
        // 对所有顶级（省份）构造孩子节点
        List<ExpressRegion> rootList = allRegions.stream()
                .filter(region -> region.getParentId() == null)
                .collect(Collectors.toList());
        // 递归为每个区域设置 children 集合
        setChildren(rootList, groupByParent);
        return rootList;
    }

    private void setChildren(List<ExpressRegion> parents, Map<Integer, List<ExpressRegion>> groupByParent) {
        if (parents == null || parents.isEmpty()) {
            return;
        }
        for (ExpressRegion parent : parents) {
            List<ExpressRegion> children = groupByParent.get(parent.getId());
            parent.setChildren(children);
            setChildren(children, groupByParent);
        }
    }

}
