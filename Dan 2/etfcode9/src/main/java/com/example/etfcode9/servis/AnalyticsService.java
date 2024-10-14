package com.example.etfcode9.servis;

import com.example.etfcode9.db.entity.Analytics;
import com.example.etfcode9.db.entity.Url;
import com.example.etfcode9.db.repository.AnalyticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnalyticsService {
    @Autowired
    private AnalyticsRepository analyticsRepository;


    public void doAnalytics(Url url) {
        Optional<Analytics> byShortUlrId = analyticsRepository.findByShortUlr(url.getShortUrl());
        if ( byShortUlrId.isPresent()) {
            Analytics analytics = byShortUlrId.get();
            analytics.setCounter(analytics.getCounter() + 1);
            analyticsRepository.save(analytics);
        } else {
            Analytics build = Analytics.builder().counter(1).shortUlr(url.getShortUrl()).build();
            analyticsRepository.save(build);
        }
    }
}
