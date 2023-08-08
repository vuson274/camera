package com.example.camera.dto;

import com.example.camera.model.Brands;
import com.example.camera.model.Categories;
import com.example.camera.model.Orders;
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
