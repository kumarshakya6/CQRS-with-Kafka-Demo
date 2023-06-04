package com.love2java.Query.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.love2java.Query.entity.Product;
import com.love2java.Query.event.ProductEvent;
import com.love2java.Query.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductQueryController {
	@Autowired
	private ProductRepository repository;
	
	
	@KafkaListener(topics = "products", groupId = "products_group")
    public void processProductEvent(String event) {
 
        System.out.println("Getting event " + event);
 
        ProductEvent productEvent = null;
        try {
            productEvent = new ObjectMapper().readValue(event, ProductEvent.class);
 
            System.out.println(productEvent);
 
            switch (productEvent.getType()) {
            case "ProductCreated":
                 
                this.repository.save(productEvent.getProduct());
                break;
 
            default:
                break;
            }
 
        } catch (Exception e) {
 
            e.printStackTrace();
        }
    }
	
	@GetMapping
    public List<Product> getProducts() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }

}
