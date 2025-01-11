package com.example.demo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class FileDownloadUtil {
    
    public static void downloadFile(HttpServletResponse response, File file, String fileName) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + fileName);
        }

        // Set correct content type
        String contentType = determineContentType(fileName);
        response.setContentType(contentType);
        
        // Set headers
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, 
            "attachment; filename=\"" + URLEncoder.encode(fileName, StandardCharsets.UTF_8.toString()) + "\"");
        response.setHeader(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate");
        response.setHeader(HttpHeaders.PRAGMA, "no-cache");
        response.setHeader(HttpHeaders.EXPIRES, "0");
        response.setContentLengthLong(file.length());

        // Stream file content
        try (BufferedInputStream inStream = new BufferedInputStream(new FileInputStream(file));
             BufferedOutputStream outStream = new BufferedOutputStream(response.getOutputStream())) {
            
            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = inStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
            outStream.flush();
        }
    }

    private static String determineContentType(String fileName) {
        String extension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
        switch (extension) {
            case "pdf":
                return MediaType.APPLICATION_PDF_VALUE;
            case "txt":
                return MediaType.TEXT_PLAIN_VALUE;
            case "doc":
            case "docx":
                return "application/msword";
            case "xls":
            case "xlsx":
                return "application/vnd.ms-excel";
            case "zip":
                return "application/zip";
            case "jpg":
            case "jpeg":
                return MediaType.IMAGE_JPEG_VALUE;
            case "png":
                return MediaType.IMAGE_PNG_VALUE;
            default:
                return MediaType.APPLICATION_OCTET_STREAM_VALUE;
        }
    }
}
