package com.example.sboot.camel.controller;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.sboot.camel.model.Product;


@RestController
@RequestMapping("/app2")
public class App2Controller {
	Logger logger = LoggerFactory.getLogger(App2Controller.class);
	
	@PostMapping("/postProductInfo")
	public void receiveMessage(@RequestBody Product product) {
		logger.info("Received message:" + product + " at: " + LocalDateTime.now());
	}
}
