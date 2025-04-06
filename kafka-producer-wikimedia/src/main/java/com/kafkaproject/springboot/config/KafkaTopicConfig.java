package com.kafkaproject.springboot.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import com.kafkaproject.springboot.Constants.Constants;


@Configuration
public class KafkaTopicConfig {
	
	@Bean
	public NewTopic newTopic() {
		return TopicBuilder.name(Constants.WIKIMEDIA_TOPIC).build();
	}
}
