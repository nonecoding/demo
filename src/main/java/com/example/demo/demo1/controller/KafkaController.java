package com.example.demo.demo1.controller;

import com.example.demo.common.response.ApiResponse;
import com.example.demo.demo1.service.KafkaProducerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

/**
 * Kafka消息控制器
 */
@RestController
@RequestMapping("/api/kafka")
@RequiredArgsConstructor
@Slf4j
@Validated
@Api(tags = "Kafka消息管理")
public class KafkaController {

    private final KafkaProducerService producerService;

    @PostMapping("/send")
    @ApiOperation("发送消息到Kafka")
    public ApiResponse<Void> sendMessage(
            @ApiParam(value = "消息内容", required = true)
            @RequestBody @NotBlank(message = "消息内容不能为空") String message) {
        
        producerService.sendMessage("my-topic", message);
        log.info("Message sent successfully: {}", message);
        return ApiResponse.success("消息发送成功", null);
    }

    @PostMapping("/send/{topic}")
    @ApiOperation("发送消息到指定主题")
    public ApiResponse<Void> sendMessageToTopic(
            @ApiParam(value = "主题名称", required = true)
            @PathVariable @NotBlank(message = "主题名称不能为空") String topic,
            @ApiParam(value = "消息内容", required = true)
            @RequestBody @NotBlank(message = "消息内容不能为空") String message) {
        
        producerService.sendMessage(topic, message);
        log.info("Message sent to topic '{}' successfully: {}", topic, message);
        return ApiResponse.success("消息发送成功", null);
    }
}
