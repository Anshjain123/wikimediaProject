package com.kafka.consumer.springboot.constants;

public class Constants {
	public static final String WIKIMEDIA_TOPIC = "wikimedia_recentchange";
	public static final String WIKIMEDIA_BOOTSTRAP_SERVERS = "localhost:9092";
	public static final String WIKIMEDIA_GROUP_ID = "my-fresh-new-group-2";
	public static final String WIKIMEDIA_CONSUMER_CONFIG = "org.apache.kafka.clients.consumer.KafkaConsumer";
	public static final String WIKIMEDIA_URL = "http://stream.wikimedia.org/v2/stream/recentchange";
}
