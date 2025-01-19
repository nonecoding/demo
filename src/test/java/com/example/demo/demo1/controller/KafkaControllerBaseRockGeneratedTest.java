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
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import com.example.demo.demo1.service.KafkaProducerService;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.hamcrest.Matchers.containsString;

@Timeout(value = 5)
@WebMvcTest()
@ContextConfiguration(classes = KafkaController.class)
class KafkaControllerBaseRockGeneratedTest {

    @Autowired()
    private MockMvc mockMvc;

    @MockBean(name = "producerService")
    private KafkaProducerService producerServiceMock;

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

    //BaseRock generated method id: ${sendMessageTest}, hash: A0CDDC1352F31465336E58EBAEB2C087
    @Test()
    void sendMessageTest() throws Exception {
        //Arrange Statement(s)
        doNothing().when(producerServiceMock).sendMessage("my-topic", "message1");
        String contentStr = new ObjectMapper().writeValueAsString("message1");
        
        //Act Statement(s)
        ResultActions resultActions = this.mockMvc.perform(post("/api/kafka/send").content(contentStr).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
        ResponseEntity<String> responseEntity = ResponseEntity.ok("Message sent successfully");
        
        //Assert statement(s)
        assertAll("result", () -> {
            resultActions.andExpect(status().is(responseEntity.getStatusCode().value()));
            resultActions.andExpect(content().string(containsString(String.valueOf(responseEntity.getBody()))));
        });
    }

    //BaseRock generated method id: ${sendMessageWhenCaughtException}, hash: 5205D22E201CB3B068247CCE9DE2F594
    @Test()
    void sendMessageWhenCaughtException() throws Exception {
        /* Branches:
         * (catch-exception (Exception)) : true
         *
         * TODO: Help needed! Please adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.
         *  The test code, including the assertion statements, has been successfully generated.
         */
         //Arrange Statement(s)
        RuntimeException runtimeExceptionMock = mock(RuntimeException.class);
        doThrow(runtimeExceptionMock).when(producerServiceMock).sendMessage("my-topic", "message1");
        String contentStr = new ObjectMapper().writeValueAsString("message1");
        
        //Act Statement(s)
        ResultActions resultActions = this.mockMvc.perform(post("/api/kafka/send").content(contentStr).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
        ResponseEntity.BodyBuilder bodyBuilder = ResponseEntity.internalServerError();
        ResponseEntity<String> responseEntity = bodyBuilder.body("Error sending message: A");
        
        //Assert statement(s)
        assertAll("result", () -> {
            resultActions.andExpect(status().is(responseEntity.getStatusCode().value()));
            resultActions.andExpect(content().string(containsString(String.valueOf(responseEntity.getBody()))));
        });
    }

    @SpringBootApplication(scanBasePackageClasses = KafkaController.class)
    static class KafkaControllerBaseRockGeneratedTestConfig {
    }
}
