package com.example.camera.repositories;

import com.example.camera.model.Order;
import com.example.camera.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    List<Order> findByCreateAtBetween(Date from_date, Date to_date);
    Iterable<Order> findAllByOrderByIdDesc();
}
