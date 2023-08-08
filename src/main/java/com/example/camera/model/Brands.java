package com.example.camera.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
@Entity
@Table(name = "Brands")
@Data
public class Brands {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Date createAt;

    public Brands() {
    }
}
