package com.example.wooden_home.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.sql.Date;
@Entity
@Table(name = "News")
@Data
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private Admin admin;
    private String title;
    @Size(max = 1000)
    private String description;
    @Size(max = 5000)
    private String content;
    private String image;
    private Date createAt;

    public News() {
    }
}
