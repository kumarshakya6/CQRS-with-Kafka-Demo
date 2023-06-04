package com.love2java.command.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.love2java.command.entity.Product;
import com.love2java.command.event.ProductEvent;
import com.love2java.command.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductCommandController {
	
	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private KafkaTemplate<String, ProductEvent> kafkaTemplate;
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		repository.save(product);
		ProductEvent event = new ProductEvent("ProductCreated", product);
        kafkaTemplate.send("products", event);
		return ResponseEntity.ok().body(product);
	}
	

}
