package com.example.camera.service;

import com.example.camera.model.Brands;

import java.util.List;
import java.util.Optional;

public interface BrandService {
    Brands save(Brands entity);

    List<Brands> saveAll(List<Brands> entities);

    Optional<Brands> findById(Integer integer);

    boolean existsById(Integer integer);

    Iterable<Brands> findAll();

    List<Brands> findAllById(List<Integer> integers);

    long count();

    void deleteById(Integer integer);

    void delete(Brands entity);

    void deleteAllById(List<Integer> integers);

    void deleteAll(List<Brands> entities);

    void deleteAll();
}
