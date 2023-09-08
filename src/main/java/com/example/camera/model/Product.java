package com.example.camera.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id")
    private Brand brand;
    private String name;
    private String origin;
    private String mainImage;
    private String secondImage;
    private Float price;
    private int quantity;
    @Size(max = 5000)
    private String description;
    private int sale;
    private float salePrice;
    private Date createAt;

    public Product() {
    }

    public Product(int id, String name, String mainImage, float price, String description, float salePrice) {
        this.id = id;
        this.name = name;
        this.mainImage = mainImage;
        this.price = price;
        this.description = description;
        this.salePrice = salePrice;
    }

    public Product(Category category, Brand brand, String name, String origin, String mainImage, String secondImage, float price, int quantity, String description, int sale, float salePrice, Date createAt) {
        this.category = category;
        this.brand = brand;
        this.name = name;
        this.origin = origin;
        this.mainImage = mainImage;
        this.secondImage = secondImage;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.sale = sale;
        this.salePrice = salePrice;
        this.createAt = createAt;
    }

    public Product(int id, Category category, Brand brand, String name, String origin, String mainImage, String secondImage, float price, int quantity, String description, int sale, float salePrice, Date createAt) {
        this.id = id;
        this.category = category;
        this.brand = brand;
        this.name = name;
        this.origin = origin;
        this.mainImage = mainImage;
        this.secondImage = secondImage;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.sale = sale;
        this.salePrice = salePrice;
        this.createAt = createAt;
    }
}
