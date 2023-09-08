package com.example.camera.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private double totalPrice;
    private String note;
    private String keyToken;
    private int payMethod;
    private Date createAt;
    private int status;

    public Order() {
    }
}
