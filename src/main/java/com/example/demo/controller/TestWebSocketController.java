package com.example.demo.controller;

import com.example.demo.service.TestWebSocket;
import com.example.demo.vo.SocketReq;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/testSocket")
public class TestWebSocketController {
    @Resource
    private TestWebSocket testWebSocket;

    @PostMapping("/send")
    public void send(@RequestBody SocketReq req) {
        testWebSocket.send(req);
    }


}
