package com.example.camera.repositories;

import com.example.camera.model.Order;
import com.example.camera.model.OrderDetail;
import com.example.camera.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderDetailRepository extends CrudRepository<OrderDetail, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM order_detail  o WHERE o.order_id = :order_id")
    List<OrderDetail> findOrderDetail(@Param("order_id") Integer order_id);
}
