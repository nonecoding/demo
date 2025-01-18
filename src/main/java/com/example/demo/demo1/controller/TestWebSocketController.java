package com.example.demo.demo1.controller;

import com.example.demo.demo1.service.TestWebSocket;
import com.example.demo.demo1.vo.SocketReq;
import io.swagger.annotations.ApiModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/testSocket")
@ApiModel(description = "测试websocket")
public class TestWebSocketController {
    @Resource
    private TestWebSocket testWebSocket;

    @PostMapping("/send")
    public void send(@RequestBody SocketReq req) {
        testWebSocket.send(req);
    }


}
