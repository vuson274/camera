package com.example.camera.service;

import com.example.camera.model.Order;
import com.example.camera.model.Product;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order save(Order entity);

    List<Order> saveAll(List<Order> entities);

    Optional<Order> findById(Integer integer);

    boolean existsById(Integer integer);

    Iterable<Order> findAll();

    List<Order> findAllById(List<Integer> integers);

    long count();

    void deleteById(Integer integer);

    void delete(Order entity);

    void deleteAllById(List<Integer> integers);

    void deleteAll(List<Order> entities);

    void deleteAll();

    List<Order> findByCreateAtBetween(Date from_date, Date to_date);

    Iterable<Order> findAllByOrderByIdDesc();
}
