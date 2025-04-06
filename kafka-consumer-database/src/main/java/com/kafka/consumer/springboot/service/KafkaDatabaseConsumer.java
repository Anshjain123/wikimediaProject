package com.kafka.consumer.springboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.consumer.springboot.constants.Constants;
import com.kafka.consumer.springboot.entity.WikimediaData;
import com.kafka.consumer.springboot.repository.WikimediaDataJPARepository;

@Service
public class KafkaDatabaseConsumer {

	private static final Logger logger = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

	@Autowired
	private WikimediaDataJPARepository wikimediaDataJPARepository;
	
	@KafkaListener(topics = Constants.WIKIMEDIA_TOPIC, groupId = Constants.WIKIMEDIA_GROUP_ID)
	public void consume(String message) {
		logger.info("Consumed message: " + message);
		WikimediaData wikimediaData = new WikimediaData();
		wikimediaData.setWikiEventData(message);
		
		wikimediaDataJPARepository.save(wikimediaData);
	}
}
