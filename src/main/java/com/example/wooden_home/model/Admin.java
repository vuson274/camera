package com.example.wooden_home.model;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
@Entity
@Table(name = "Admin")
@Data
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String email;
    private String password;
    private String phone;
    private Date createAt;

    public Admin() {
    }
}
