package com.example.urlshortener.dto;

public class ApiResponse<T> {
    private String message;
    private Integer errorCode;
    private T data;

    public ApiResponse(String message, Integer errorCode, T data) {
        this.message = message;
        this.errorCode = errorCode;
        this.data = data;
    }

    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(message, null, data);
    }

    public static <T> ApiResponse<T> failure(String message, Integer errorCode) {
        return new ApiResponse<>(message, errorCode, null);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
