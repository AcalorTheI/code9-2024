package com.example.etfcode9.servis;

import com.example.etfcode9.db.entity.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
public class CacheServis {

    @Autowired
    private Jedis jedis;
    
    public Url getUrl(String shortUrl) {


        String longUrl = jedis.get(shortUrl);
        if (longUrl == null) {
            return null;
        }
        return Url.builder().longUrl(longUrl).shortUrl(shortUrl).build();
    }

    public void saveUrl(Url url) {
        jedis.set(url.getShortUrl(), url.getLongUrl());
    }
}
