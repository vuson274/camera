package com.example.camera.service;

import com.example.camera.model.Categories;
import com.example.camera.model.Products;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    Products save(Products entity);

    List<Products> saveAll(List<Products> entities);

    Optional<Products> findById(Integer integer);

    boolean existsById(Integer integer);

    Iterable<Products> findAll(Pageable pageable);

    List<Products> findAllById(List<Integer> integers);

    long count();

    void deleteById(Integer integer);

    void delete(Products entity);

    void deleteAllById(List<Integer> integers);

    void deleteAll(List<Products> entities);

    void deleteAll();

    Iterable<Products> findAllByOrderByIdDesc();

    List<Products> findTop5ByOrderByIdDesc();

    List<Products> findTop5ByOrderByPriceDesc();

    List<Products> findTop5ByOrderByPriceAsc();

    List<Products> findTop8ByCategoryOrderByIdDesc(Categories categories);

    List<Products> findByNameLike(String name);

    List<Products> findByCreateAtBetween(Date from_date, Date to_date);


    @Query(nativeQuery = true, value = "SELECT * FROM products  ORDER BY id DESC LIMIT :from,20")
    List<Products> findByProOrderByIdDesc(Integer from);
}
