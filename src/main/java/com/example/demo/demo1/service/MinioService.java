package com.example.demo.demo1.service;

import io.minio.GetObjectArgs;
import io.minio.PutObjectArgs;
import io.minio.MinioClient;
import io.minio.errors.MinioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Service
public class MinioService {

    @Autowired
    private MinioClient minioClient;

    @Value("${spring.minio.bucket}")
    private String bucketName;

    public String uploadFile(MultipartFile file) {
        try {
            // 上传文件到MinIO
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(file.getOriginalFilename())
                            .stream(file.getInputStream(), file.getSize(), -1)
                            .contentType(file.getContentType())
                            .build()
            );
            return "File uploaded successfully: " + file.getOriginalFilename();
        } catch (MinioException e) {
            e.printStackTrace();
            return "Error occurred: " + e.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred: " + e.getMessage();
        }
    }

    public InputStream downloadFile(String fileName) {
        try {
            // 下载文件从MinIO
            return minioClient.getObject(
                    GetObjectArgs.builder()
                            .bucket(bucketName)
                            .object(fileName)
                            .build()
            );
        } catch (MinioException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}