package com.example.demo.common.websocket;

//import com.example.demo.service.JobService;
import com.example.demo.common.utils.JsonUtil;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@ServerEndpoint("/websocket/{userId}")
@Slf4j
public class WebSocketEndpoint {
    
    private static final Map<String, Session> sessionMap = new ConcurrentHashMap<>();
    private static final Map<String, String> userSessionMap = new ConcurrentHashMap<>();
    
    // Need to get Spring beans in ServerEndpoint
    private static final Set<WebSocketEndpoint> ENDPOINTS = new CopyOnWriteArraySet<>();
    
    @Autowired
//    private JobService jobService;  // Example service injection
    
    public WebSocketEndpoint() {
        ENDPOINTS.add(this);
    }
    
    @OnOpen
    public void onOpen(Session session, @PathParam("userId") String userId) {
        try {
            // Store both session and user mapping
            sessionMap.put(session.getId(), session);
            userSessionMap.put(userId, session.getId());
            
            // Send connection confirmation
            HashMap<String, Object> map = new HashMap<>();
            map.put("type", "CONNECTED");
            map.put("userId", userId);
            map.put("timestamp",System.currentTimeMillis());
            sendMessage(session, JsonUtil.toJson(
                    map
//                Map.of(
//                    "type", "CONNECTED",
//                    "userId", userId,
//                    "timestamp", System.currentTimeMillis()
//                )
//                    "gtu6tyiytuoyuioy8uio"
            ));
        } catch (Exception e) {
            log.error("Error in onOpen: ", e);
        }
    }
    
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info(message);
//        try {
//            // Parse incoming message
//            JsonNode jsonNode = JsonUtil.parse(message);
//            String type = jsonNode.get("type").asText();
//
//            // Handle different message types
//            switch (type) {
//                case "PING":
//                    handlePing(session);
//                    break;
//                case "JOB_STATUS":
//                    handleJobStatus(jsonNode, session);
//                    break;
//                // Add more message type handlers as needed
//            }
//        } catch (Exception e) {
//            log.error("Error in onMessage: ", e);
//            sendError(session, "Failed to process message");
//        }
    }
    
    @OnClose
    public void onClose(Session session) {
        // Clean up session
        String sessionId = session.getId();
        sessionMap.remove(sessionId);
        
        // Remove user mapping
        userSessionMap.entrySet()
            .removeIf(entry -> entry.getValue().equals(sessionId));
    }
    
    @OnError
    public void onError(Session session, Throwable throwable) {
        log.error("WebSocket error for session " + session.getId(), throwable);
        try {
            session.close();
        } catch (IOException e) {
            log.error("Error closing session", e);
        }
    }
    
    // Utility methods for sending messages
    public void sendMessageToUser(String userId, String message) {
        try {
            String sessionId = userSessionMap.get(userId);
            if (sessionId != null) {
                Session session = sessionMap.get(sessionId);
                if (session != null && session.isOpen()) {
                    sendMessage(session, message);
                }
            }
        } catch (Exception e) {
            log.error("Error sending message to user: " + userId, e);
        }
    }
    
    public void broadcast(String message) {
        sessionMap.values().forEach(session -> {
            if (session.isOpen()) {
                sendMessage(session, message);
            }
        });
    }
    
    private void sendMessage(Session session, String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            log.error("Error sending message to session: " + session.getId(), e);
        }
    }
    
    private void handlePing(Session session) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("type", "PONG");
        map.put("timestamp", System.currentTimeMillis());
        sendMessage(session, JsonUtil.toJson(
                map
//            Map.of(
//                "type", "PONG",
//                "timestamp", System.currentTimeMillis()
//            )
//                "gtu6tyiytuoyuioy8uio"
        ));
    }
    
    private void handleJobStatus(JsonNode jsonNode, Session session) {
        // Handle job status updates
        String jobId = jsonNode.get("jobId").asText();
        // Process job status...
    }
    
    private void sendError(Session session, String errorMessage) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("type", "ERROR");
        map.put("message", errorMessage);
        map.put("timestamp", System.currentTimeMillis());
        sendMessage(session, JsonUtil.toJson(
                map
//            Map.of(
//                "type", "ERROR",
//                "message", errorMessage,
//                "timestamp", System.currentTimeMillis()
//            )
//                "gtu6tyiytuoyuioy8uio"
        ));
    }
}