package com.example.camera.repositories;

import com.example.camera.model.Category;
import com.example.camera.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Iterable<Product> findAllByOrderByIdDesc();
    List<Product> findTop5ByOrderByIdDesc();
    List<Product> findTop5ByOrderByPriceDesc();
    List<Product> findTop5ByOrderByPriceAsc();
    List<Product> findTop8ByCategoryOrderByIdDesc(Category categories);
    List<Product> findByNameLike(String name);
    List<Product> findByCreateAtBetween(Date from_date, Date to_date);
    @Query(nativeQuery = true, value = "SELECT * FROM products  ORDER BY id DESC LIMIT :from, 20")
    List<Product> findByProOrderByIdDesc(Integer from);
}