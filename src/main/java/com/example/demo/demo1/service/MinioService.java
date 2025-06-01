package com.example.demo.demo1.service;

import com.example.demo.common.exception.BusinessException;
import io.minio.*;
import io.minio.errors.MinioException;
import io.minio.messages.Item;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * MinIO文件服务类
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class MinioService {

    private final MinioClient minioClient;

    @Value("${spring.minio.bucket}")
    private String bucketName;

    private static final long MAX_FILE_SIZE = 100 * 1024 * 1024; // 100MB
    private static final List<String> ALLOWED_EXTENSIONS = Arrays.asList(
            "jpg", "jpeg", "png", "gif", "pdf", "doc", "docx", "xls", "xlsx", "txt", "zip"
    );

    @PostConstruct
    public void init() {
        try {
            // 检查桶是否存在，不存在则创建
            boolean exists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
            if (!exists) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
                log.info("Created bucket: {}", bucketName);
            }
        } catch (Exception e) {
            log.error("Failed to initialize MinIO bucket: {}", bucketName, e);
            throw new BusinessException("MinIO初始化失败");
        }
    }

    /**
     * 上传文件
     */
    public String uploadFile(MultipartFile file) {
        validateFile(file);
        
        try {
            String fileName = generateFileName(file.getOriginalFilename());
            
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(fileName)
                            .stream(file.getInputStream(), file.getSize(), -1)
                            .contentType(file.getContentType())
                            .build()
            );
            
            log.info("File uploaded successfully: {} -> {}", file.getOriginalFilename(), fileName);
            return fileName;
        } catch (MinioException e) {
            log.error("MinIO error uploading file: {}", file.getOriginalFilename(), e);
            throw new BusinessException("文件上传失败: " + e.getMessage());
        } catch (Exception e) {
            log.error("Error uploading file: {}", file.getOriginalFilename(), e);
            throw new BusinessException("文件上传失败");
        }
    }

    /**
     * 批量上传文件
     */
    public List<String> uploadFiles(MultipartFile[] files) {
        List<String> uploadedFiles = new ArrayList<>();
        
        for (MultipartFile file : files) {
            try {
                String fileName = uploadFile(file);
                uploadedFiles.add(fileName);
            } catch (Exception e) {
                log.error("Failed to upload file: {}", file.getOriginalFilename(), e);
                // 继续上传其他文件，但记录失败的文件
            }
        }
        
        return uploadedFiles;
    }

    /**
     * 下载文件
     */
    public InputStream downloadFile(String fileName) {
        if (!StringUtils.hasText(fileName)) {
            throw new BusinessException("文件名不能为空");
        }
        
        try {
            return minioClient.getObject(
                    GetObjectArgs.builder()
                            .bucket(bucketName)
                            .object(fileName)
                            .build()
            );
        } catch (MinioException e) {
            log.error("MinIO error downloading file: {}", fileName, e);
            throw new BusinessException("文件下载失败: " + e.getMessage());
        } catch (Exception e) {
            log.error("Error downloading file: {}", fileName, e);
            throw new BusinessException("文件下载失败");
        }
    }

    /**
     * 删除文件
     */
    public void deleteFile(String fileName) {
        if (!StringUtils.hasText(fileName)) {
            throw new BusinessException("文件名不能为空");
        }
        
        try {
            minioClient.removeObject(
                    RemoveObjectArgs.builder()
                            .bucket(bucketName)
                            .object(fileName)
                            .build()
            );
            log.info("File deleted successfully: {}", fileName);
        } catch (MinioException e) {
            log.error("MinIO error deleting file: {}", fileName, e);
            throw new BusinessException("文件删除失败: " + e.getMessage());
        } catch (Exception e) {
            log.error("Error deleting file: {}", fileName, e);
            throw new BusinessException("文件删除失败");
        }
    }

    /**
     * 获取文件列表
     */
    public List<String> listFiles() {
        List<String> files = new ArrayList<>();
        
        try {
            Iterable<Result<Item>> results = minioClient.listObjects(
                    ListObjectsArgs.builder()
                            .bucket(bucketName)
                            .build()
            );
            
            for (Result<Item> result : results) {
                Item item = result.get();
                files.add(item.objectName());
            }
            
            log.info("Listed {} files from bucket: {}", files.size(), bucketName);
            return files;
        } catch (Exception e) {
            log.error("Error listing files from bucket: {}", bucketName, e);
            throw new BusinessException("获取文件列表失败");
        }
    }

    /**
     * 检查文件是否存在
     */
    public boolean fileExists(String fileName) {
        if (!StringUtils.hasText(fileName)) {
            return false;
        }
        
        try {
            minioClient.statObject(
                    StatObjectArgs.builder()
                            .bucket(bucketName)
                            .object(fileName)
                            .build()
            );
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 验证文件
     */
    private void validateFile(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new BusinessException("文件不能为空");
        }
        
        if (file.getSize() > MAX_FILE_SIZE) {
            throw new BusinessException("文件大小不能超过100MB");
        }
        
        String originalFilename = file.getOriginalFilename();
        if (!StringUtils.hasText(originalFilename)) {
            throw new BusinessException("文件名不能为空");
        }
        
        String extension = getFileExtension(originalFilename);
        if (!ALLOWED_EXTENSIONS.contains(extension.toLowerCase())) {
            throw new BusinessException("不支持的文件类型: " + extension);
        }
    }

    /**
     * 生成唯一文件名
     */
    private String generateFileName(String originalFilename) {
        String extension = getFileExtension(originalFilename);
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        return timestamp + "_" + uuid + "." + extension;
    }

    /**
     * 获取文件扩展名
     */
    private String getFileExtension(String filename) {
        if (!StringUtils.hasText(filename) || !filename.contains(".")) {
            return "";
        }
        return filename.substring(filename.lastIndexOf(".") + 1);
    }
}