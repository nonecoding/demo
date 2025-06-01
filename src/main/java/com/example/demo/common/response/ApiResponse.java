package com.example.demo.common.response;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 统一API响应格式
 */
@Data
@Accessors(chain = true)
public class ApiResponse<T> {
    private int code;
    private String message;
    private T data;
    private long timestamp;

    public ApiResponse() {
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<T>()
                .setCode(200)
                .setMessage("Success")
                .setData(data);
    }

    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<T>()
                .setCode(200)
                .setMessage(message)
                .setData(data);
    }

    public static <T> ApiResponse<T> error(int code, String message) {
        return new ApiResponse<T>()
                .setCode(code)
                .setMessage(message);
    }

    public static <T> ApiResponse<T> error(String message) {
        return error(500, message);
    }
}