package com.example.demo.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class KafkaProducer {
    @Value("${spring.kafka.topic}")
    private String topic;
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

   /*success

    @Scheduled(fixedRate = 3000)
    public void send() {
        kafkaTemplate.send(topic, "哈喽" + System.currentTimeMillis());
    }*/
}
