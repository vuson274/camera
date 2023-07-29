package com.example.wooden_home.service;

import com.example.wooden_home.model.Products;
import com.example.wooden_home.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductsRepository productRepository;

    @Override
    public Products  save(Products entity) {
        return productRepository.save(entity);
    }

    @Override
    public List<Products> saveAll(List<Products> entities) {
        return (List<Products>) productRepository.saveAll(entities);
    }

    @Override
    public Optional<Products> findById(Integer integer) {
        return productRepository.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return productRepository.existsById(integer);
    }

    @Override
    public Iterable<Products> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Products> findAllById(List<Integer> integers) {
        return (List<Products>) productRepository.findAllById(integers);
    }

    @Override
    public long count() {
        return productRepository.count();
    }

    @Override
    public void deleteById(Integer integer) {
        productRepository.deleteById(integer);
    }

    @Override
    public void delete(Products entity) {
        productRepository.delete(entity);
    }

    @Override
    public void deleteAllById(List<Integer> integers) {
        productRepository.deleteAllById(integers);
    }

    @Override
    public void deleteAll(List<Products> entities) {
        productRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        productRepository.deleteAll();
    }
}
