package com.example.wooden_home.repositories;

import com.example.wooden_home.model.Products;
import org.springframework.data.repository.CrudRepository;

public interface ProductsRepository extends CrudRepository<Products, Integer> {
}