package com.kafkaproject.springboot.service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafkaproject.springboot.Constants.Constants;
import com.kafkaproject.springboot.helper.WikimediaChangesHandler;
import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import com.launchdarkly.eventsource.background.BackgroundEventSource;

@Service
public class WikimediaChangesProducer {
	
	private static final Logger logger = LoggerFactory.getLogger(WikimediaChangesProducer.class);
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessage(String message) throws InterruptedException {
		logger.info("Message sent: " + message);
		
		/** to read the real time stream data from wikimedia, we use event source
		 * event source are like for listening to server sent events, that is, a stream of data that is being listened by this application
		 * we will listen it from http://stream.wikimedia.org/v2/stream/recentchange	
		 */
		
		listenEvents(); 
//		TimeUnit.MINUTES.sleep(10);
		
	}
	
	private void listenEvents() {
		BackgroundEventHandler backgroundEventHandler = new WikimediaChangesHandler(kafkaTemplate, Constants.WIKIMEDIA_TOPIC);
		String url = Constants.WIKIMEDIA_URL;
		EventSource.Builder builder = new EventSource.Builder(URI.create(url));
		BackgroundEventSource backgroundEventSource = new BackgroundEventSource.Builder(backgroundEventHandler, builder).build();
		backgroundEventSource.start(); 
	}
}
