package com.example.camera.service;

import com.example.camera.model.Category;
import com.example.camera.model.Product;
import com.example.camera.repositories.ProductRepository;
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
    ProductRepository productRepository;

    @Override
    public Product save(Product entity) {
        return productRepository.save(entity);
    }

    @Override
    public List<Product> saveAll(List<Product> entities) {
        return (List<Product>) productRepository.saveAll(entities);
    }

    @Override
    public Optional<Product> findById(Integer integer) {
        return productRepository.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return productRepository.existsById(integer);
    }

    @Override
    public Iterable<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public List<Product> findAllById(List<Integer> integers) {
        return (List<Product>) productRepository.findAllById(integers);
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
    public void delete(Product entity) {
        productRepository.delete(entity);
    }

    @Override
    public void deleteAllById(List<Integer> integers) {
        productRepository.deleteAllById(integers);
    }

    @Override
    public void deleteAll(List<Product> entities) {
        productRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        productRepository.deleteAll();
    }

    @Override
    public Iterable<Product> findAllByOrderByIdDesc() {
        return productRepository.findAllByOrderByIdDesc();
    }

    @Override
    public List<Product> findTop5ByOrderByIdDesc() {
        return productRepository.findTop5ByOrderByIdDesc();
    }

    @Override
    public List<Product> findTop5ByOrderByPriceDesc() {
        return productRepository.findTop5ByOrderByPriceDesc();
    }

    @Override
    public List<Product> findTop5ByOrderByPriceAsc() {
        return productRepository.findTop5ByOrderByPriceAsc();
    }

    @Override
    public List<Product> findTop8ByCategoryOrderByIdDesc(Category categories) {
        return productRepository.findTop8ByCategoryOrderByIdDesc(categories);
    }

    @Override
    public List<Product> findByNameLike(String name) {
        return productRepository.findByNameLike("%"+name+"%");
    }

    @Override
    public List<Product> findByCreateAtBetween(Date from_date, Date to_date) {
        return productRepository.findByCreateAtBetween(from_date, to_date);
    }

    @Override
    @Query(nativeQuery = true, value = "SELECT * FROM products  ORDER BY id DESC LIMIT :from,20")
    public List<Product> findByProOrderByIdDesc(Integer from) {
        return productRepository.findByProOrderByIdDesc(from);
    }
}
