package com.example.wooden_home.dto;
import com.example.wooden_home.model.Admin;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
@Data
public class NewsDTO {
    private int id;
    private Admin admin;
    private String title;
    private String description;
    private String content;
    private MultipartFile image;
    private Date createAt;

    public NewsDTO() {
    }
}
