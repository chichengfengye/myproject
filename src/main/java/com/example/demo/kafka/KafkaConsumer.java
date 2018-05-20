package com.example.demo.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

//@Component
public class KafkaConsumer {

    @KafkaListener(topics = "${spring.kafka.topic}")
    public void receive(String message) {
        System.out.println(message);
    }
}
