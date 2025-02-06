package com.example.demo.express.item.controller;

import com.example.demo.express.item.entity.ExpressItemInfo;

import com.example.demo.express.item.service.ExpressItemInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/expressItem")
public class ExpressItemInfoController {

    @Autowired
    private ExpressItemInfoServiceImpl expressItemInfoService;

    // Create
    @PostMapping
    public String createExpressItemInfo(@RequestBody ExpressItemInfo expressItemInfo) {
        expressItemInfoService.createExpressItemInfo(expressItemInfo);
        return "Create Successful";
    }

    // Read by id
    @GetMapping("/{id}")
    public ExpressItemInfo getExpressItemInfo(@PathVariable Integer id) {
        return expressItemInfoService.getExpressItemInfo(id);
    }

    // Read paginated list
    @GetMapping
    public List<ExpressItemInfo> getExpressItemInfoPage(@RequestParam(defaultValue = "1") int page,
                                                        @RequestParam(defaultValue = "10") int pageSize) {
        return expressItemInfoService.getExpressItemInfoPage(page, pageSize);
    }

    // Update
    @PutMapping("/{id}")
    public String updateExpressItemInfo(@PathVariable Integer id, @RequestBody ExpressItemInfo expressItemInfo) {
        expressItemInfo.setId(id);
        expressItemInfoService.updateExpressItemInfo(expressItemInfo);
        return "Update Successful";
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deleteExpressItemInfo(@PathVariable Integer id) {
        expressItemInfoService.deleteExpressItemInfo(id);
        return "Delete Successful";
    }
}