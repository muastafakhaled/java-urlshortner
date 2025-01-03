package com.example.urlshortener.repository;

import com.example.urlshortener.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UrlRepository extends JpaRepository<Url, Integer> {

    Url findByShortUrl(String shortUrl);
}
