//package com.example.demo.common.kafka;
//
//public class LoggingMiddleware extends KafkaMiddleware<String> {
//    @Override
//    public String process(String message) {
//        logger.info("Message passing through middleware: {}", message);
//        return message;
//    }
//}