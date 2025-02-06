package com.example.demo.common.exception;

public class AppException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private final int statusCode;

    public AppException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}