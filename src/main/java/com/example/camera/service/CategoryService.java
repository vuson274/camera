package com.example.camera.service;

import com.example.camera.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Category save(Category entity);

    List<Category> saveAll(List<Category> entities);

    Optional<Category> findById(Integer integer);

    boolean existsById(Integer integer);

    Iterable<Category> findAll();

    List<Category> findAllById(List<Integer> integers);

    long count();

    void deleteById(Integer integer);

    void delete(Category entity);

    void deleteAllById(List<Integer> integers);

    void deleteAll(List<Category> entities);

    void deleteAll();
}
