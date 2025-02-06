package com.example.demo.express.order.service;

import com.example.demo.express.order.entity.ExpressOrder;
import com.example.demo.express.order.mapper.ExpressOrderMapper;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpressOrderServiceImpl{

    @Autowired
    private ExpressOrderMapper expressOrderMapper;


    public ExpressOrder createExpressOrder(ExpressOrder order) {
        expressOrderMapper.insert(order);
        return order;
    }


    public ExpressOrder getExpressOrderById(Integer id) {
        return expressOrderMapper.selectById(id);
    }


    public boolean updateExpressOrder(ExpressOrder order) {
        order.setUpdateTime(LocalDateTime.now());
        int rows = expressOrderMapper.update(order);
        return rows > 0;
    }


    public boolean deleteExpressOrder(Integer id) {
        int rows = expressOrderMapper.deleteById(id);
        return rows > 0;
    }


    public List<ExpressOrder> getExpressOrders(int page, int size) {
        int offset = (page - 1) * size;
        return expressOrderMapper.selectPage(offset, size);
    }
}
