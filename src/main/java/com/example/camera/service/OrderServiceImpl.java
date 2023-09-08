package com.example.camera.service;

import com.example.camera.model.Order;
import com.example.camera.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order save(Order entity) {
        return orderRepository.save(entity);
    }

    @Override
    public List<Order> saveAll(List<Order> entities) {
        return (List<Order>) orderRepository.saveAll(entities);
    }

    @Override
    public Optional<Order> findById(Integer integer) {
        return orderRepository.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return orderRepository.existsById(integer);
    }

    @Override
    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> findAllById(List<Integer> integers) {
        return (List<Order>) orderRepository.findAllById(integers);
    }

    @Override
    public long count() {
        return orderRepository.count();
    }

    @Override
    public void deleteById(Integer integer) {
        orderRepository.deleteById(integer);
    }

    @Override
    public void delete(Order entity) {
        orderRepository.delete(entity);
    }

    @Override
    public void deleteAllById(List<Integer> integers) {
        orderRepository.deleteAllById(integers);
    }

    @Override
    public void deleteAll(List<Order> entities) {
        orderRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        orderRepository.deleteAll();
    }

    @Override
    public List<Order> findByCreateAtBetween(Date from_date, Date to_date) {
        return orderRepository.findByCreateAtBetween(from_date, to_date);
    }

    @Override
    public Iterable<Order> findAllByOrderByIdDesc() {
        return orderRepository.findAllByOrderByIdDesc();
    }
}
