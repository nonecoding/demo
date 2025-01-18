//package com.example.demo.common.kafka;
//
//
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.apache.kafka.clients.consumer.ConsumerRecords;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.time.Duration;
//import java.util.Collections;
//import java.util.List;
//import java.util.Properties;
//
//public class KafkaConsumer<K, V> {
//    private final org.apache.kafka.clients.consumer.KafkaConsumer<K, V> consumer;
//    private final List<KafkaMiddleware<V>> middlewareChain;
//    private final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
//    private volatile boolean running = true;
//
//    public KafkaConsumer(Properties properties, List<KafkaMiddleware<V>> middlewareChain) {
//        this.consumer = new org.apache.kafka.clients.consumer.KafkaConsumer<>(properties);
//        this.middlewareChain = middlewareChain;
//    }
//
//    public void subscribe(String topic, MessageHandler<V> handler) {
//        consumer.subscribe(Collections.singletonList(topic));
//
//        try {
//            while (running) {
//                ConsumerRecords<K, V> records = consumer.poll(Duration.ofMillis(100));
//
//                for (ConsumerRecord<K, V> record : records) {
//                    V message = record.value();
//
//                    // Apply middleware chain
//                    for (KafkaMiddleware<V> middleware : middlewareChain) {
//                        message = middleware.handleMessage(message);
//                    }
//
//                    // Process the final message
//                    handler.handle(message);
//                }
//            }
//        } finally {
//            consumer.close();
//        }
//    }
//
//    public void stop() {
//        running = false;
//    }
//}
//
//
