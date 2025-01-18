//package com.example.demo.common.config;
//
//import java.util.Properties;
//
//public class KafkaConfig {
//    private Properties properties;
//
//    public KafkaConfig(String bootstrapServers, String groupId) {
//        if (bootstrapServers == null || bootstrapServers.trim().isEmpty()) {
//            throw new IllegalArgumentException("Bootstrap servers configuration cannot be null or empty");
//        }
//        if (groupId == null || groupId.trim().isEmpty()) {
//            throw new IllegalArgumentException("Group ID cannot be null or empty");
//        }
//
//        properties = new Properties();
//
//        // Common configs
//        properties.put("bootstrap.servers", bootstrapServers);
//        properties.put("group.id", groupId);
//
//        // Consumer specific configs
//        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        properties.put("auto.offset.reset", "earliest");
//
//        // Producer specific configs
//        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        properties.put("acks", "all");
//        properties.put("retries", 3);
//    }
//
//    public Properties getProperties() {
//        return properties;
//    }
//}
//
