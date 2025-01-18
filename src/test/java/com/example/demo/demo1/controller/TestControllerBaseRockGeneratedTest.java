package com.example.demo.demo1.controller;

import org.junit.jupiter.api.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.context.ContextConfiguration;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@Timeout(value = 5)
@WebMvcTest()
@ContextConfiguration(classes = TestController.class)
class TestControllerBaseRockGeneratedTest {

    @Autowired()
    private MockMvc mockMvc;

    private AutoCloseable autoCloseableMocks;

    @AfterEach()
    public void afterTest() throws Exception {
        if (autoCloseableMocks != null)
            autoCloseableMocks.close();
    }

    //BaseRock generated method id: ${helloTest}, hash: 7FF75F5CA023A4E3174AA30077262A46
    @Test()
    void helloTest() throws Exception {
        
        //Act Statement(s)
        ResultActions resultActions = this.mockMvc.perform(get("/api/test/hello").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
        
        //Assert statement(s)
        assertAll("result", () -> {
            resultActions.andExpect(status().isOk());
            resultActions.andExpect(content().string(containsString("Hello World")));
        });
    }

    @SpringBootApplication(scanBasePackageClasses = TestController.class)
    static class TestControllerBaseRockGeneratedTestConfig {
    }
}
