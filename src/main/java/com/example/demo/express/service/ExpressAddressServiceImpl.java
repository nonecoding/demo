package com.example.demo.express.service;

import com.example.demo.express.entity.ExpressAddress;
import com.example.demo.express.mapper.ExpressAddressMapper;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xj
 * @since 2025-02-05
 */
@Service
public class ExpressAddressServiceImpl{

    @Autowired
    private ExpressAddressMapper expressAddressMapper;

    public int create(ExpressAddress expressAddress) {
        expressAddress.setCreateTime(LocalDateTime.now());
        expressAddress.setUpdateTime(LocalDateTime.now());
        return expressAddressMapper.insert(expressAddress);
    }

    public int delete(Integer id) {
        return expressAddressMapper.deleteById(id);
    }

    public int update(ExpressAddress expressAddress) {
        expressAddress.setUpdateTime(LocalDateTime.now());
        return expressAddressMapper.update(expressAddress);
    }

    public ExpressAddress getById(Integer id) {
        return expressAddressMapper.selectById(id);
    }

    public List<ExpressAddress> getPage(int pageNum, int pageSize) {
        int offset = (pageNum - 1) * pageSize;
        return expressAddressMapper.selectPage(offset, pageSize);
    }

    public int countAll() {
        return expressAddressMapper.countAll();
    }

}
