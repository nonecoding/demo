package com.example.demo.express.region.controller;


import com.example.demo.express.region.entity.ExpressRegion;
import com.example.demo.express.region.service.ExpressRegionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xj
 * @since 2025-02-06
 */
@RestController
@RequestMapping("/express-region")
public class ExpressRegionController {


    @Autowired
    private ExpressRegionServiceImpl expressRegionService;

    @GetMapping("/tree")
    public List<ExpressRegion> getRegionTree() {
        return expressRegionService.getRegionTree();
    }

}
