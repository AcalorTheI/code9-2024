package com.example.etfcode9.servis.config;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@EnableJms
public class ActiveMQConfig {

//    @Bean
//    public JmsTemplate jmsTemplate(ActiveMQConnectionFactory connectionFactory) {
//        JmsTemplate jmsTemplate = new JmsTemplate();
//        jmsTemplate.setConnectionFactory(connectionFactory);
//        return jmsTemplate;
//    }
}