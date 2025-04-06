package com.kafkaproject.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafkaproject.springboot.service.WikimediaChangesProducer;

@RestController
public class MessageController {

	@Autowired
	private WikimediaChangesProducer producer; 
	
	@GetMapping("/send")
	public String sendMessage() {
		try {
			producer.sendMessage("hey");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}
