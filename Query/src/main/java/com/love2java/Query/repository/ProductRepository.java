package com.love2java.Query.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.love2java.Query.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
