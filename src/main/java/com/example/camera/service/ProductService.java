package com.example.camera.service;

import com.example.camera.model.Category;
import com.example.camera.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product save(Product entity);

    List<Product> saveAll(List<Product> entities);

    Optional<Product> findById(Integer integer);

    boolean existsById(Integer integer);

    Iterable<Product> findAll(Pageable pageable);

    List<Product> findAllById(List<Integer> integers);

    long count();

    void deleteById(Integer integer);

    void delete(Product entity);

    void deleteAllById(List<Integer> integers);

    void deleteAll(List<Product> entities);

    void deleteAll();

    Iterable<Product> findAllByOrderByIdDesc();

    List<Product> findTop5ByOrderByIdDesc();

    List<Product> findTop5ByOrderByPriceDesc();

    List<Product> findTop5ByOrderByPriceAsc();

    List<Product> findTop8ByCategoryOrderByIdDesc(Category categories);

    List<Product> findByNameLike(String name);

    List<Product> findByCreateAtBetween(Date from_date, Date to_date);


    @Query(nativeQuery = true, value = "SELECT * FROM products  ORDER BY id DESC LIMIT :from,20")
    List<Product> findByProOrderByIdDesc(Integer from);
}
