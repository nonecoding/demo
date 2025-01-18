//package com.example.demo.common.kafka;
//
//import org.apache.kafka.clients.producer.ProducerRecord;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.Properties;
//
//public class KafkaProducer<K, V> {
//    private final org.apache.kafka.clients.producer.KafkaProducer<K, V> producer;
//    private final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
//
//    public KafkaProducer(Properties properties) {
//        this.producer = new org.apache.kafka.clients.producer.KafkaProducer<>(properties);
//    }
//
//    public void send(String topic, V message) {
//        ProducerRecord<K, V> record = new ProducerRecord<>(topic, message);
//        producer.send(record, (metadata, exception) -> {
//            if (exception == null) {
//                logger.info("Message sent successfully to topic {} partition {} offset {}",
//                    metadata.topic(), metadata.partition(), metadata.offset());
//            } else {
//                logger.error("Error sending message", exception);
//            }
//        });
//    }
//
//    public void close() {
//        producer.close();
//    }
//}
