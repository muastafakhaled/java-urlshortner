package com.example.urlshortener.service;

import com.example.urlshortener.entity.Url;
import com.example.urlshortener.repository.UrlRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.UnknownHttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.Random;

@Service
public class UrlService {

    private final UrlRepository urlRepository;
    //Logger
    private static final Logger logger = LoggerFactory.getLogger(UrlService.class);

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public String ShortenUrl(String originalUrl) {

        try {
            String ShortUrl = generateShortCode();
            logger.info("Shortening URL: " + originalUrl + " to " + ShortUrl);

            Url url = new Url();

            url.setOriginalUrl(originalUrl);
            url.setShortUrl(ShortUrl);

            urlRepository.save(url);

            return ShortUrl;
        } catch (Exception e) {
            logger.error("Error while shortening URL: " + originalUrl);
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        }


    }

    public String getOriginalUrl(String shortUrl){
        Url url = urlRepository.findByShortUrl(shortUrl);

        if(url == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Url Found");
        }

        return url.getOriginalUrl();
    }


    private String generateShortCode() {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder code = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            code.append(chars.charAt(random.nextInt(chars.length())));
        }
        return code.toString();
    }
}
