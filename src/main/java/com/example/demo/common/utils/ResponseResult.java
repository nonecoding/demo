package com.example.demo.common.utils;

import lombok.Data;

@Data
public class ResponseResult<T> {
    private Integer code;
    private String message;
    private T data;
    private Long timestamp;
    private Boolean success;

    public static <T> ResponseResult<T> success(T data) {
        ResponseResult<T> result = new ResponseResult<>();
        result.setCode(200);
        result.setMessage("Success");
        result.setData(data);
        result.setTimestamp(System.currentTimeMillis());
        result.setSuccess(true);
        return result;
    }

    public static <T> ResponseResult<T> error(Integer code, String message) {
        ResponseResult<T> result = new ResponseResult<>();
        result.setCode(code);
        result.setMessage(message);
        result.setTimestamp(System.currentTimeMillis());
        result.setSuccess(false);
        return result;
    }
}
