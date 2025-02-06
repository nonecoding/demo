package com.example.demo.express.order.controller;

import com.example.demo.express.order.entity.ExpressOrder;

import java.util.List;

import com.example.demo.express.order.service.ExpressOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expressOrder")
public class ExpressOrderController {

    @Autowired
    private ExpressOrderServiceImpl expressOrderService;

    // 创建新的 ExpressOrder
    @PostMapping
    public ExpressOrder createExpressOrder(@RequestBody ExpressOrder order) {
        return expressOrderService.createExpressOrder(order);
    }

    // 根据 id 查询 ExpressOrder
    @GetMapping("/{id}")
    public ExpressOrder getExpressOrder(@PathVariable Integer id) {
        return expressOrderService.getExpressOrderById(id);
    }

    // 更新 ExpressOrder
    @PutMapping("/{id}")
    public String updateExpressOrder(@PathVariable Integer id, @RequestBody ExpressOrder order) {
        order.setId(id);
        boolean success = expressOrderService.updateExpressOrder(order);
        return success ? "Update successful" : "Update failed";
    }

    // 根据 id 删除 ExpressOrder
    @DeleteMapping("/{id}")
    public String deleteExpressOrder(@PathVariable Integer id) {
        boolean success = expressOrderService.deleteExpressOrder(id);
        return success ? "Delete successful" : "Delete failed";
    }

    // 分页查询 ExpressOrder，page 为 1 开始
    @GetMapping
    public List<ExpressOrder> getExpressOrders(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return expressOrderService.getExpressOrders(page, size);
    }
}