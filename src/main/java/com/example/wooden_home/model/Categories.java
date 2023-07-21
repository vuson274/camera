package com.example.wooden_home.model;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Date;


@Entity
@Table(name = "Categories")
@Data
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Date createAt;

    public Categories() {
    }

}
