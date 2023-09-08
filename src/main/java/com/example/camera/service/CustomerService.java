package com.example.camera.service;

import com.example.camera.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer save(Customer entity);

    Optional<Customer> findById(Integer integer);

    Iterable<Customer> findAll();

    long count();

    void deleteById(Integer integer);

    void delete(Customer entity);

    void deleteAllById(List<Integer> integers);

    void deleteAll(List<Customer> entities);

    void deleteAll();
}
