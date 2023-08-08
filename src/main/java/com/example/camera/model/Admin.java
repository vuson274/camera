package com.example.camera.model;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
@Entity
@Table(name = "Admin")
@Data
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    private String email;
    private String password;
    private String phone;
    private String image;
    private Date createAt;

    public Admin() {
    }

    public Admin(int id, String userName, String email, String password, String phone, String image) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.image = image;
    }

    public Admin(String userName, String email, String password, String phone, String image) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.image = image;
    }
}
