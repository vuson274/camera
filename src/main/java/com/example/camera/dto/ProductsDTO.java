package com.example.camera.dto;

import com.example.camera.model.Brand;
import com.example.camera.model.Category;
import com.example.camera.model.Order;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
@Data
public class ProductsDTO {
    private int id;
    private Category category;
    private Brand brand;
    private String name;
    private String origin;
    private MultipartFile mainImage;
    private MultipartFile secondImage;
    private float price;
    private int quantity;
    private String description;
    private int sale;
    private float salePrice;
    private Set<Order> orders = new HashSet<Order>();
    private Date createAt;

    public ProductsDTO() {
    }
}
