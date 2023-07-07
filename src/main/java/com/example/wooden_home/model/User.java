package com.example.wooden_home.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
@Entity
@Table(name = "User")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userName;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String address;
    private Date dateOfBirth;
    private boolean sex;
    private Date createAt;

    public User() {
    }
}
