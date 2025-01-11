package com.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Test Interface")
@RestController
@RequestMapping("/api/test")
public class TestController {

    @ApiOperation("Hello World Test")
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
