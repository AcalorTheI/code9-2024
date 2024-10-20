package com.example.etfcode9.db.repository;

import com.example.etfcode9.db.entity.Url;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends CrudRepository<Url, Integer> {
    Optional<Url> findByShortUrl(String shortUrl);
}
