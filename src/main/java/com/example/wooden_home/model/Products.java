package com.example.wooden_home.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Products")
@Data
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Categories category;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brands brand;
    private String name;
    private String origin;
    private String mainImage;
    private String secondImage;
    private float price;
    private int quantity;
    @Size(max = 2000)
    private String description;
    private int sale;
    private float salePrice;
    @ManyToMany(mappedBy = "products")
    private Set<Orders> orders = new HashSet<Orders>();
    private Date createAt;

    public Products() {
    }

    public Products(Categories category, Brands brand, String name, String origin, String mainImage, String secondImage, float price, int quantity, String description, int sale, float salePrice, Date createAt) {
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

    public Products(int id, Categories category, Brands brand, String name, String origin, String mainImage, String secondImage, float price, int quantity, String description, int sale, float salePrice, Date createAt) {
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
