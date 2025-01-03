package com.example.urlshortener.enums;

import lombok.Getter;


public enum ErrorCode {
    SUCCESS(0, "SUCCESS"),
    URL_NOT_FOUND(1, "URL_NOT_FOUND"),
    INVALID_URL(2, "INVALID_URL"),
    INTERNAL_SERVER_ERROR(500, "INTERNAL_SERVER_ERROR");

    ErrorCode(int code, String defaultMessage) {
        this.code = code;
        this.defaultMessage = defaultMessage;
    }

    private final int code;
    private final String defaultMessage;

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public int getCode() {
        return code;
    }
}
