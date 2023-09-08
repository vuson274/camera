package com.example.camera.model;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Date;


@Entity
@Table(name = "Categories")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Date createAt;

    public Category() {
    }

}
