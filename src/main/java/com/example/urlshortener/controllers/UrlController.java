package com.example.urlshortener.controllers;

import com.example.urlshortener.entity.Url;
import com.example.urlshortener.service.UrlService;
import jakarta.servlet.http.HttpServletResponse;
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
    public String shortenUrl(String originalUrl) {
        return urlService.ShortenUrl(originalUrl);
    }

    @GetMapping("/{shortUrl}")
    public void originalUrl(@PathVariable String shortUrl, HttpServletResponse response) {
        try {
            String originalUrl = urlService.getOriginalUrl(shortUrl);
            response.sendRedirect(originalUrl);
        } catch (IOException e) {
            throw new RuntimeException("Failed to redirect", e);
        }
    }
}
