package com.example.demo.demo1.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String message) {
        log.info("Sending message to topic {}: {}", topic, message);
        kafkaTemplate.send(topic, message)
                .addCallback(
                        result -> log.info("Message sent successfully"),
                        ex -> log.error("Failed to send message", ex)
                );
    }
}
