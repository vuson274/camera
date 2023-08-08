package com.example.camera.model;

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
    @Size(max = 2000)
    private String description;
    @Size(max = 10000)
    private String content;
    private String image;
    private Date createAt;

    public News() {
    }

    public News(Admin admin, String title, String description, String content, String image, Date createAt) {
        this.admin = admin;
        this.title = title;
        this.description = description;
        this.content = content;
        this.image = image;
        this.createAt = createAt;
    }

    public News(int id, Admin admin, String title, String description, String content, String image, Date createAt) {
        this.id = id;
        this.admin = admin;
        this.title = title;
        this.description = description;
        this.content = content;
        this.image = image;
        this.createAt = createAt;
    }
}
