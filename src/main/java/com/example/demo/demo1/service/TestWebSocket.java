package com.example.demo.demo1.service;

import com.example.demo.demo1.vo.SocketReq;
import com.example.demo.common.websocket.WebSocketEndpoint;
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
