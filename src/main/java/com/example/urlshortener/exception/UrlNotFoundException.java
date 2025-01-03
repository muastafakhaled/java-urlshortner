package com.example.urlshortener.exception;

import com.example.urlshortener.enums.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UrlNotFoundException extends RuntimeException {
    public UrlNotFoundException(String message) {
        super(message);
    }


    public UrlNotFoundException() {
        super(ErrorCode.URL_NOT_FOUND.getDefaultMessage());
    }
}
