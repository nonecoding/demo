package com.example.demo;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
@RestController
@RequestMapping("/test")
public class Test {
    @GetMapping("/download")
    public void downloadFile(@RequestBody FilePath file, HttpServletResponse response) {
        File file1 = new File("D:\\11111.xlsx");
        try {
            // Get your file here
                    FileDownloadUtil.downloadFile(response, file1, "11111.xlsx");
        } catch (IOException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }


}
