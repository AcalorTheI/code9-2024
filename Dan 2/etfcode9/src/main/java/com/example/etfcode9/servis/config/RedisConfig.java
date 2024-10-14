package com.example.etfcode9.servis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

@Configuration
public class RedisConfig {
    @Value("${redis.port}")
    private Integer redisPort;

    @Value("${redis.url}")
    private String redisUrl;

    @Bean
    public Jedis getJedis() {
        return new Jedis(redisUrl, redisPort);
    }
}
