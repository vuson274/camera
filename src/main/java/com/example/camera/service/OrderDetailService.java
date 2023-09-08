package com.example.camera.service;

import com.example.camera.model.OrderDetail;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderDetailService {
    OrderDetail save(OrderDetail entity);

    List<OrderDetail> saveAll(List<OrderDetail> entities);

    Optional<OrderDetail> findById(Integer integer);

    boolean existsById(Integer integer);

    Iterable<OrderDetail> findAll();

    List<OrderDetail> findAllById(List<Integer> integers);

    long count();

    void deleteById(Integer integer);

    void delete(OrderDetail entity);

    void deleteAllById(List<Integer> integers);

    void deleteAll(List<OrderDetail> entities);

    void deleteAll();


    @Query(nativeQuery = true, value = "SELECT * FROM order_detail  o WHERE o.order_id = :order_id")
    List<OrderDetail> findOrderDetail(Integer order_id);
}
