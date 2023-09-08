package com.example.camera.service;

import com.example.camera.model.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandService {
    Brand save(Brand entity);

    List<Brand> saveAll(List<Brand> entities);

    Optional<Brand> findById(Integer integer);

    boolean existsById(Integer integer);

    Iterable<Brand> findAll();

    List<Brand> findAllById(List<Integer> integers);

    long count();

    void deleteById(Integer integer);

    void delete(Brand entity);

    void deleteAllById(List<Integer> integers);

    void deleteAll(List<Brand> entities);

    void deleteAll();
}
