package com.example.wooden_home.dto;

import com.example.wooden_home.model.Brands;
import com.example.wooden_home.model.Categories;
import com.example.wooden_home.model.Orders;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
@Data
public class ProductsDTO {
    private int id;
    private Categories category;
    private Brands brand;
    private String name;
    private String origin;
    private MultipartFile mainImage;
    private MultipartFile secondImage;
    private float price;
    private int quantity;
    private String description;
    private int sale;
    private float salePrice;
    private Set<Orders> orders = new HashSet<Orders>();
    private Date createAt;

    public ProductsDTO() {
    }
}
