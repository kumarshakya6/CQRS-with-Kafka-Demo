package com.love2java.command.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.love2java.command.entity.Product;

public interface ProductRepository  extends JpaRepository<Product, Long>{

}
