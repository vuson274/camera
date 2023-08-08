package com.example.camera.service;

import com.example.camera.model.Categories;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Categories save(Categories entity);

    List<Categories> saveAll(List<Categories> entities);

    Optional<Categories> findById(Integer integer);

    boolean existsById(Integer integer);

    Iterable<Categories> findAll();

    List<Categories> findAllById(List<Integer> integers);

    long count();

    void deleteById(Integer integer);

    void delete(Categories entity);

    void deleteAllById(List<Integer> integers);

    void deleteAll(List<Categories> entities);

    void deleteAll();
}
