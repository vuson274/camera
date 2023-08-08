package com.example.camera.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "Customer")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phone;
    private String email;
    private String address;
    @OneToMany(mappedBy = "customer")
    private List<Orders> orders;
    private Date createAt;

    public Customer() {
    }
}
