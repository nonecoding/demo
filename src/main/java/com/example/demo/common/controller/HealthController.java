package com.example.demo.common.controller;

import com.example.demo.common.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * 健康检查控制器
 */
@RestController
@RequestMapping("/api/health")
@Slf4j
@Api(tags = "健康检查")
public class HealthController {

    @Value("${spring.application.name:demo-application}")
    private String applicationName;

    @GetMapping
    @ApiOperation("健康检查")
    public ApiResponse<Map<String, Object>> health() {
        Map<String, Object> healthInfo = new HashMap<>();
        healthInfo.put("status", "UP");
        healthInfo.put("application", applicationName);
        healthInfo.put("timestamp", LocalDateTime.now());
        healthInfo.put("version", "1.0.0");
        
        return ApiResponse.success("应用运行正常", healthInfo);
    }

    @GetMapping("/ping")
    @ApiOperation("简单ping检查")
    public ApiResponse<String> ping() {
        return ApiResponse.success("pong");
    }
}