package com.example.wooden_home.repositories;

import com.example.wooden_home.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Integer> {
}