package com.example.wooden_home.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
@Entity
@Table(name = "Slide")
@Data
public class Slide {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String description;
    private String image;
    private Date createAt;

    public Slide() {
    }
}
