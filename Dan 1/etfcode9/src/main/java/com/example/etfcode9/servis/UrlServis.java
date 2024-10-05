package com.example.etfcode9.servis;

import com.example.etfcode9.db.entity.Url;
import com.example.etfcode9.db.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UrlServis {
    @Autowired
    private UrlRepository urlRepository;

    public Url redirection(String shortUrl) {
        Optional<Url> byShortUrl = urlRepository.findByShortUrl(shortUrl);
        if (byShortUrl.isPresent()) {
            return byShortUrl.get();
        } else {
            return null;
        }
    }

    public Url getById(Integer id) {
        Optional<Url> byId = urlRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        } else {
            return null;
        }
    }

    public Url save(Url url) {
        return urlRepository.save(url);
    }

    public Url update(Url url) {
        return urlRepository.save(url);
    }
    public void deleteById(Integer id) {
        urlRepository.deleteById(id);
    }
}
