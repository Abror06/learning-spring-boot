package com.example.learningspringboot.repository;

import com.example.learningspringboot.model.Category;
import com.example.learningspringboot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
