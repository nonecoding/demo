package com.example.demo.express.address.controller;


import com.example.demo.express.address.entity.ExpressAddress;
import com.example.demo.express.address.service.ExpressAddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xj
 * @since 2025-02-05
 */
@RestController
@RequestMapping("/express-address")
public class ExpressAddressController {

    @Autowired
    private ExpressAddressServiceImpl expressAddressService;

    @PostMapping("/create")
    public String create(@RequestBody ExpressAddress expressAddress) {
        expressAddressService.create(expressAddress);
        return "Create success";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        expressAddressService.delete(id);
        return "Delete success";
    }

    @PutMapping("/update")
    public String update(@RequestBody ExpressAddress expressAddress) {
        expressAddressService.update(expressAddress);
        return "Update success";
    }

    @GetMapping("/get/{id}")
    public ExpressAddress get(@PathVariable Integer id) {
        return expressAddressService.getById(id);
    }

    @GetMapping("/list")
    public List<ExpressAddress> list(@RequestParam(defaultValue = "1") int pageNum,
                                     @RequestParam(defaultValue = "10") int pageSize) {
        return expressAddressService.getPage(pageNum, pageSize);
    }

}
