package com.example.camera.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
@Data
public class AdminDTO {
    private int id;
    private String userName;
    private String email;
    private String password;
    private String phone;
    private MultipartFile image;
    private Date createAt;

    public AdminDTO() {
    }

    public AdminDTO(int id, String userName, String email, String password, String phone, MultipartFile image, Date createAt) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.image = image;
        this.createAt = createAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

}
