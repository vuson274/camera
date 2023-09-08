package com.example.camera.service;

import com.example.camera.model.OrderDetail;
import com.example.camera.repositories.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{
    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Override
    public OrderDetail save(OrderDetail entity) {
        return orderDetailRepository.save(entity);
    }

    @Override
    public List<OrderDetail> saveAll(List<OrderDetail> entities) {
        return (List<OrderDetail>) orderDetailRepository.saveAll(entities);
    }

    @Override
    public Optional<OrderDetail> findById(Integer integer) {
        return orderDetailRepository.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return orderDetailRepository.existsById(integer);
    }

    @Override
    public Iterable<OrderDetail> findAll() {
        return orderDetailRepository.findAll();
    }

    @Override
    public List<OrderDetail> findAllById(List<Integer> integers) {
        return (List<OrderDetail>) orderDetailRepository.findAllById(integers);
    }

    @Override
    public long count() {
        return orderDetailRepository.count();
    }

    @Override
    public void deleteById(Integer integer) {
        orderDetailRepository.deleteById(integer);
    }

    @Override
    public void delete(OrderDetail entity) {
        orderDetailRepository.delete(entity);
    }

    @Override
    public void deleteAllById(List<Integer> integers) {
        orderDetailRepository.deleteAllById(integers);
    }

    @Override
    public void deleteAll(List<OrderDetail> entities) {
        orderDetailRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        orderDetailRepository.deleteAll();
    }

    @Override
    @Query(nativeQuery = true, value = "SELECT * FROM order_detail  o WHERE o.order_id = :order_id")
    public List<OrderDetail> findOrderDetail(Integer order_id) {
        return orderDetailRepository.findOrderDetail(order_id);
    }
}
