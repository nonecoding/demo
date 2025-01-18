package com.example.demo.demo1.controller;

import com.example.demo.common.utils.FileDownloadUtil;
import com.example.demo.demo1.vo.FilePath;
import io.swagger.annotations.ApiModel;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
@RestController
@RequestMapping("/test")
@ApiModel(description = "测试下载文件")
public class Test {
    @GetMapping("/download")
    public void downloadFile(@RequestBody FilePath file, HttpServletResponse response) {
        File file1 = new File("D:\\白头鹰.jpg");
        try {
            // Get your file here
                    FileDownloadUtil.downloadFile(response, file1, "白头鹰.jpg");
        } catch (IOException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }


}
