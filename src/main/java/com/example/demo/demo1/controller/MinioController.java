package com.example.demo.demo1.controller;

import com.example.demo.common.response.ApiResponse;
import com.example.demo.common.utils.FileDownloadUtil;
import com.example.demo.demo1.service.MinioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.InputStream;
import java.util.List;

/**
 * MinIO文件管理控制器
 */
@RestController
@RequestMapping("/api/minio")
@RequiredArgsConstructor
@Slf4j
@Validated
@Api(tags = "MinIO文件管理")
public class MinioController {

    private final MinioService minioService;

    @PostMapping("/upload")
    @ApiOperation("上传文件")
    public ApiResponse<String> uploadFile(
            @ApiParam(value = "上传的文件", required = true)
            @RequestParam("file") @NotNull(message = "文件不能为空") MultipartFile file) {
        
        if (file.isEmpty()) {
            return ApiResponse.error("文件内容不能为空");
        }
        
        String result = minioService.uploadFile(file);
        log.info("File uploaded successfully: {}", file.getOriginalFilename());
        return ApiResponse.success("文件上传成功", result);
    }

    @PostMapping("/upload/batch")
    @ApiOperation("批量上传文件")
    public ApiResponse<List<String>> uploadFiles(
            @ApiParam(value = "上传的文件列表", required = true)
            @RequestParam("files") @NotNull(message = "文件列表不能为空") MultipartFile[] files) {
        
        if (files.length == 0) {
            return ApiResponse.error("文件列表不能为空");
        }
        
        List<String> results = minioService.uploadFiles(files);
        log.info("Batch upload completed, {} files uploaded", files.length);
        return ApiResponse.success("批量上传成功", results);
    }

    @GetMapping("/download/{fileName}")
    @ApiOperation("下载文件")
    public ResponseEntity<byte[]> downloadFile(
            @ApiParam(value = "文件名", required = true)
            @PathVariable @NotBlank(message = "文件名不能为空") String fileName) {
        
        InputStream inputStream = minioService.downloadFile(fileName);
        return FileDownloadUtil.createDownloadResponse(inputStream, fileName);
    }

    @DeleteMapping("/{fileName}")
    @ApiOperation("删除文件")
    public ApiResponse<Void> deleteFile(
            @ApiParam(value = "文件名", required = true)
            @PathVariable @NotBlank(message = "文件名不能为空") String fileName) {
        
        minioService.deleteFile(fileName);
        log.info("File deleted successfully: {}", fileName);
        return ApiResponse.success("文件删除成功", null);
    }

    @GetMapping("/list")
    @ApiOperation("获取文件列表")
    public ApiResponse<List<String>> listFiles() {
        List<String> files = minioService.listFiles();
        return ApiResponse.success("获取文件列表成功", files);
    }

    @GetMapping("/exists/{fileName}")
    @ApiOperation("检查文件是否存在")
    public ApiResponse<Boolean> fileExists(
            @ApiParam(value = "文件名", required = true)
            @PathVariable @NotBlank(message = "文件名不能为空") String fileName) {
        
        boolean exists = minioService.fileExists(fileName);
        return ApiResponse.success("检查完成", exists);
    }
}