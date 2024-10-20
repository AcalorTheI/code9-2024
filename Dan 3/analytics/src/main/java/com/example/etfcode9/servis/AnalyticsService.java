package com.example.etfcode9.servis;

import com.example.etfcode9.db.entity.Analytics;
import com.example.etfcode9.db.repository.AnalyticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnalyticsService {
    @Autowired
    private AnalyticsRepository analyticsRepository;


    public void doAnalytics(String shortUrl) {
        Optional<Analytics> byShortUlrId = analyticsRepository.findByShortUlr(shortUrl);
        if ( byShortUlrId.isPresent()) {
            Analytics analytics = byShortUlrId.get();
            analytics.setCounter(analytics.getCounter() + 1);
            analyticsRepository.save(analytics);
        } else {
            Analytics build = Analytics.builder().counter(1).shortUlr(shortUrl).build();
            analyticsRepository.save(build);
        }
    }
}
