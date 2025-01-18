package com.example.demo.demo1.controller;

import org.junit.jupiter.api.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.mockito.MockitoAnnotations;
import com.example.demo.demo1.vo.SocketReq;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.context.ContextConfiguration;
import com.example.demo.demo1.service.TestWebSocket;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@Timeout(value = 5)
@WebMvcTest()
@ContextConfiguration(classes = TestWebSocketController.class)
class TestWebSocketControllerBaseRockGeneratedTest {

    @Autowired()
    private MockMvc mockMvc;

    @MockBean(name = "testWebSocket")
    private TestWebSocket testWebSocketMock;

    private AutoCloseable autoCloseableMocks;

    @BeforeEach()
    public void beforeTest() {
        autoCloseableMocks = MockitoAnnotations.openMocks(this);
    }

    @AfterEach()
    public void afterTest() throws Exception {
        if (autoCloseableMocks != null)
            autoCloseableMocks.close();
    }

    //BaseRock generated method id: ${sendTest}, hash: 84ECB15325A7D763AF8938980CCF3AA3
    @Test()
    void sendTest() throws Exception {
        //Arrange Statement(s)
        SocketReq socketReq = new SocketReq();
        doNothing().when(testWebSocketMock).send(socketReq);
        String contentStr = new ObjectMapper().writeValueAsString(socketReq);
        
        //Act Statement(s)
        ResultActions resultActions = this.mockMvc.perform(post("/testSocket/send").content(contentStr).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
        
        //Assert statement(s)
        assertAll("result", () -> resultActions.andExpect(status().isOk()));
    }

    @SpringBootApplication(scanBasePackageClasses = TestWebSocketController.class)
    static class TestWebSocketControllerBaseRockGeneratedTestConfig {
    }
}
