package com.example.demo.service;

import com.example.demo.vo.SocketReq;
import com.example.demo.websocket.WebSocketEndpoint;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestWebSocket {
    @Resource
    WebSocketEndpoint webSocketEndpoint;

    public void send(SocketReq req) {
        //处理信息过程

        //发送消息
        webSocketEndpoint.sendMessageToUser(req.getUserId(), req.getMessage());
    }
}
