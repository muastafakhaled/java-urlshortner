package com.example.urlshortener.controllers;

import com.example.urlshortener.dto.ApiResponse;
import com.example.urlshortener.enums.ErrorCode;
import com.example.urlshortener.service.UrlService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/url")
public class UrlController {
    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }


    @PostMapping("/shorten")
    public ResponseEntity<ApiResponse<String>> shortenUrl(String originalUrl) {
        String url = urlService.ShortenUrl(originalUrl);
        return ResponseEntity.ok(ApiResponse.success(ErrorCode.SUCCESS.getDefaultMessage(), url));
    }

    @GetMapping("/{shortUrl}")
    public void originalUrl(@PathVariable String shortUrl, HttpServletResponse response) throws IOException {
        String originalUrl = urlService.getOriginalUrl(shortUrl);
        response.sendRedirect(originalUrl);
    }
}
