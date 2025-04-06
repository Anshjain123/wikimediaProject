package com.kafkaproject.springboot.Constants;

public class Constants {
	public static final String WIKIMEDIA_TOPIC = "wikimedia_recentchange";
	public static final String WIKIMEDIA_BOOTSTRAP_SERVERS = "localhost:9092";
	public static final String WIKIMEDIA_PRODUCER_CONFIG = "org.apache.kafka.clients.producer.KafkaProducer";
	public static final String WIKIMEDIA_URL = "http://stream.wikimedia.org/v2/stream/recentchange";
}
