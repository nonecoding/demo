//package com.example.demo.demo1.service;
//
//import com.example.demo.common.config.KafkaConfig;
//import com.example.demo.common.kafka.KafkaConsumer;
//import com.example.demo.common.kafka.KafkaMiddleware;
//import com.example.demo.common.kafka.KafkaProducer;
//import com.example.demo.common.kafka.LoggingMiddleware;
//
//import java.util.Arrays;
//import java.util.List;
//
//public class KafkaExample {
//    public static void main(String[] args) {
//        String bootstrapServers = System.getenv("KAFKA_BOOTSTRAP_SERVERS");
//        String groupId = "my-consumer-group";
//        String topic = "my-topic";
//
//        try {
//            // Validate bootstrap servers
//            if (bootstrapServers == null || bootstrapServers.trim().isEmpty()) {
//                throw new IllegalStateException(
//                        "KAFKA_BOOTSTRAP_SERVERS environment variable must be set. " +
//                                "Please set it to your Kafka broker addresses (e.g., localhost:9092)"
//                );
//            }
//
//            // Create configuration
//            KafkaConfig config = new KafkaConfig(bootstrapServers, groupId);
//
//            // Create producer
//            KafkaProducer<String, String> producer = new KafkaProducer<>(config.getProperties());
//
//            // Create middleware chain
//            List<KafkaMiddleware<String>> middlewareChain = Arrays.asList(
//                    new LoggingMiddleware()
//                    // Add more middleware as needed
//            );
//
//            // Create consumer
//            KafkaConsumer<String, String> consumer = new KafkaConsumer<>(config.getProperties(), middlewareChain);
//
//            // Start consumer in separate thread
//            Thread consumerThread = new Thread(() -> {
//                consumer.subscribe(topic, message -> {
//                    System.out.println("Received message: " + message);
//                    // Add your message processing logic here
//                });
//            });
//            consumerThread.start();
//
//            // Send some messages
//            producer.send(topic, "Hello, Kafka!");
//            producer.send(topic, "Another message");
//
//            // Cleanup
//            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//                consumer.stop();
//                producer.close();
//            }));
//
//        } catch (IllegalStateException | IllegalArgumentException e) {
//            System.err.println("Configuration error: " + e.getMessage());
//            System.exit(1);
//        } catch (Exception e) {
//            System.err.println("An unexpected error occurred: " + e.getMessage());
//            e.printStackTrace();
//            System.exit(1);
//        }
//    }
//}
//
