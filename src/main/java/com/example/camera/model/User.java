package com.example.camera.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
@Entity
@Table(name = "User")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String address;
    private Date dateOfBirth;
    private Date createAt;

    public User() {
    }

    public User(String userName, String password, String name, String email, String phone, String address, Date dateOfBirth, Date createAt) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.createAt = createAt;
    }
}
