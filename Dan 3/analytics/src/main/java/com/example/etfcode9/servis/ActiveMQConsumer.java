package com.example.etfcode9.servis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class ActiveMQConsumer {

    @Autowired
    private AnalyticsService analyticsService;

    @JmsListener(destination = "analitika")
    public void readMessage(String message) {
        analyticsService.doAnalytics(message);
    }
}
