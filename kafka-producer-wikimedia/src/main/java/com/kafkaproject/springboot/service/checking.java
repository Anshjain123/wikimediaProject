//package com.kafkaproject.springboot.service;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//@Service
//public class checking {
//	private static final Logger logger = LoggerFactory.getLogger(checking.class);
//
//	@KafkaListener(topics = "wikimedia_recentchange", groupId = "my-new-group-id-123")
//	public void consume(String eventMessage) {
//		logger.info("Consumed message: " + eventMessage);
//	}
//}
