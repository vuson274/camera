package com.example.camera.service;

import com.example.camera.model.Categories;
import com.example.camera.model.Products;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Products save(Products entity);

    List<Products> saveAll(List<Products> entities);

    Optional<Products> findById(Integer integer);

    boolean existsById(Integer integer);

    Iterable<Products> findAll();

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
}
