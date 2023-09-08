package com.example.camera.service;

import com.example.camera.model.Customer;
import com.example.camera.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerSeviceImpl implements CustomerService{
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer save(Customer entity) {
        return customerRepository.save(entity);
    }

    @Override
    public Optional<Customer> findById(Integer integer) {
        return customerRepository.findById(integer);
    }

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public long count() {
        return customerRepository.count();
    }

    @Override
    public void deleteById(Integer integer) {
        customerRepository.deleteById(integer);
    }

    @Override
    public void delete(Customer entity) {
        customerRepository.delete(entity);
    }

    @Override
    public void deleteAllById(List<Integer> integers) {
        customerRepository.deleteAllById(integers);
    }

    @Override
    public void deleteAll(List<Customer> entities) {
        customerRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        customerRepository.deleteAll();
    }
}
