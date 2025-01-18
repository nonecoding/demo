package com.example.demo.demo1.service;

import org.junit.jupiter.api.Timeout;
import org.mockito.InjectMocks;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import com.example.demo.common.websocket.WebSocketEndpoint;
import org.mockito.MockitoAnnotations;
import com.example.demo.demo1.vo.SocketReq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doReturn;

@Timeout(value = 5)
class TestWebSocketBaseRockGeneratedTest {

    private final WebSocketEndpoint webSocketEndpointMock = mock(WebSocketEndpoint.class, "webSocketEndpoint");

    private AutoCloseable autoCloseableMocks;

    @InjectMocks()
    private TestWebSocket target;

    @AfterEach()
    public void afterTest() throws Exception {
        if (autoCloseableMocks != null)
            autoCloseableMocks.close();
    }

    //BaseRock generated method id: ${sendTest}, hash: D73BBED990992FBBB0E03B32FDEA8E59
    @Test()
    void sendTest() {
        //Arrange Statement(s)
        SocketReq reqMock = mock(SocketReq.class);
        doReturn("return_of_getUserId1").when(reqMock).getUserId();
        doReturn("return_of_getMessage1").when(reqMock).getMessage();
        doNothing().when(webSocketEndpointMock).sendMessageToUser("return_of_getUserId1", "return_of_getMessage1");
        target = new TestWebSocket();
        autoCloseableMocks = MockitoAnnotations.openMocks(this);
        
        //Act Statement(s)
        target.send(reqMock);
        
        //Assert statement(s)
        assertAll("result", () -> {
            verify(reqMock).getUserId();
            verify(reqMock).getMessage();
            verify(webSocketEndpointMock).sendMessageToUser("return_of_getUserId1", "return_of_getMessage1");
        });
    }
}
