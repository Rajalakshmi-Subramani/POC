package com.example.sboot.camel.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sboot.camel.model.Product;

@RestController
@RequestMapping("/app1")
public class App1Controller {
	@GetMapping("/getProductInfo")
	public Product getProductInfo() {
		Long id  = new Random().nextLong();
		return new Product(id,"Camel Product Info "+ id);
	}
}
