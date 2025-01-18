//package com.example.demo.common.kafka;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public abstract class KafkaMiddleware<T> {
//    protected final Logger logger = LoggerFactory.getLogger(getClass());
//
//    public abstract T process(T message);
//
//    public T handleMessage(T message) {
//        try {
//            logger.info("Processing message through middleware");
//            return process(message);
//        } catch (Exception e) {
//            logger.error("Error processing message in middleware", e);
//            throw e;
//        }
//    }
//}
//
//// Example implementation
//
