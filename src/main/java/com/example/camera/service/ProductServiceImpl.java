package com.example.camera.service;

import com.example.camera.model.Categories;
import com.example.camera.model.Products;
import com.example.camera.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.sql.Date;
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
    public Iterable<Products> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
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

    @Override
    public Iterable<Products> findAllByOrderByIdDesc() {
        return productRepository.findAllByOrderByIdDesc();
    }

    @Override
    public List<Products> findTop5ByOrderByIdDesc() {
        return productRepository.findTop5ByOrderByIdDesc();
    }

    @Override
    public List<Products> findTop5ByOrderByPriceDesc() {
        return productRepository.findTop5ByOrderByPriceDesc();
    }

    @Override
    public List<Products> findTop5ByOrderByPriceAsc() {
        return productRepository.findTop5ByOrderByPriceAsc();
    }

    @Override
    public List<Products> findTop8ByCategoryOrderByIdDesc(Categories categories) {
        return productRepository.findTop8ByCategoryOrderByIdDesc(categories);
    }

    @Override
    public List<Products> findByNameLike(String name) {
        return productRepository.findByNameLike("%"+name+"%");
    }

    @Override
    public List<Products> findByCreateAtBetween(Date from_date, Date to_date) {
        return productRepository.findByCreateAtBetween(from_date, to_date);
    }

    @Override
    @Query(nativeQuery = true, value = "SELECT * FROM products  ORDER BY id DESC LIMIT :from,20")
    public List<Products> findByProOrderByIdDesc(Integer from) {
        return productRepository.findByProOrderByIdDesc(from);
    }
}
