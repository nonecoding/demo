package com.example.demo.demo1.controller;

import org.junit.jupiter.api.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.junit.jupiter.api.AfterEach;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mockito.stubbing.Answer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import javax.servlet.http.HttpServletResponse;
import com.example.demo.common.utils.FileDownloadUtil;
import com.example.demo.demo1.vo.FilePath;
import javax.servlet.http.HttpServletResponseWrapper;
import org.springframework.test.web.servlet.ResultActions;
import org.mockito.MockedStatic;
import java.io.File;
import org.springframework.test.context.ContextConfiguration;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@Timeout(value = 5)
@WebMvcTest()
@ContextConfiguration(classes = Test.class)
class TestBaseRockGeneratedTest {

    @Autowired()
    private MockMvc mockMvc;

    private AutoCloseable autoCloseableMocks;

    private final HttpServletResponse httpServletResponseMock = mock(HttpServletResponse.class);

    @AfterEach()
    public void afterTest() throws Exception {
        if (autoCloseableMocks != null)
            autoCloseableMocks.close();
    }

    //BaseRock generated method id: ${downloadFileTest}, hash: 893043F2EAD3D1A7F3DF58508D6C78A4
    @org.junit.jupiter.api.Test()
    void downloadFileTest() throws Exception {
        //Arrange Statement(s)
        try (MockedStatic<FileDownloadUtil> fileDownloadUtil = mockStatic(FileDownloadUtil.class)) {
            HttpServletResponseWrapper httpServletResponseWrapper = new HttpServletResponseWrapper(httpServletResponseMock);
            HttpServletResponseWrapper httpServletResponseWrapper2 = new HttpServletResponseWrapper(httpServletResponseWrapper);
            fileDownloadUtil.when(() -> FileDownloadUtil.downloadFile(eq(httpServletResponseWrapper2), (File) any(), eq("\u767D\u5934\u9E70.jpg"))).thenAnswer((Answer<Void>) invocation -> null);
            FilePath filePath = new FilePath();
            String contentStr = new ObjectMapper().writeValueAsString(filePath);
            //Act Statement(s)
            ResultActions resultActions = this.mockMvc.perform(get("/test/download").content(contentStr).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
            //Assert statement(s)
            assertAll("result", () -> resultActions.andExpect(status().isOk()));
        }
    }

    //BaseRock generated method id: ${downloadFileWhenCaughtIOException}, hash: 7B94DDBCD9C111B05EECE45C9909D66A
    @org.junit.jupiter.api.Test()
    void downloadFileWhenCaughtIOException() throws Exception {
        /* Branches:
         * (catch-exception (IOException)) : true
         *
         * TODO: Help needed! Please adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.
         *  The test code, including the assertion statements, has been successfully generated.
         */
         //Arrange Statement(s)
        try (MockedStatic<FileDownloadUtil> fileDownloadUtil = mockStatic(FileDownloadUtil.class)) {
            HttpServletResponseWrapper httpServletResponseWrapper = new HttpServletResponseWrapper(httpServletResponseMock);
            HttpServletResponseWrapper httpServletResponseWrapper2 = new HttpServletResponseWrapper(httpServletResponseWrapper);
            fileDownloadUtil.when(() -> FileDownloadUtil.downloadFile(eq(httpServletResponseWrapper2), (File) any(), eq("\u767D\u5934\u9E70.jpg"))).thenAnswer((Answer<Void>) invocation -> null);
            FilePath filePath = new FilePath();
            String contentStr = new ObjectMapper().writeValueAsString(filePath);
            //Act Statement(s)
            ResultActions resultActions = this.mockMvc.perform(get("/test/download").content(contentStr).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
            //Assert statement(s)
            assertAll("result", () -> resultActions.andExpect(status().isOk()));
        }
    }

    @SpringBootApplication(scanBasePackageClasses = Test.class)
    static class TestBaseRockGeneratedTestConfig {
    }
}
