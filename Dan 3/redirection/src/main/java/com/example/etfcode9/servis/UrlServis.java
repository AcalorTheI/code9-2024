package com.example.etfcode9.servis;

import com.example.etfcode9.db.entity.Url;
import com.example.etfcode9.db.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UrlServis {
    @Value("${spring.jms.template.default-destination}")
    private String queue;

    @Autowired
    private UrlRepository urlRepository;
    @Autowired
    private CacheServis cacheServis;

    @Autowired
    private JmsTemplate jmsTemplate;

    public Url redirection(String shortUrl) {
        Url url = cacheServis.getUrl(shortUrl);
        if (url == null) {
            Optional<Url> byShortUrl = urlRepository.findByShortUrl(shortUrl);
            if (byShortUrl.isPresent()) {
                jmsTemplate.convertAndSend(queue, byShortUrl.get().getShortUrl());
                cacheServis.saveUrl(byShortUrl.get());
                return  byShortUrl.get();
            } else {
                return null;
            }

        } else {
            jmsTemplate.convertAndSend(queue, url.getShortUrl());
            return url;
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
