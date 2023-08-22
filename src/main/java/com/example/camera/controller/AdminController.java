package com.example.camera.controller;

import com.example.camera.config.AES;
import com.example.camera.dto.AdminDTO;
import com.example.camera.model.Admin;
import com.example.camera.service.AdminService;
import com.example.camera.service.ProductService;
import com.example.camera.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired
    ProductService productService;
    @Autowired
    UserSevice userSevice;

    @GetMapping("/dashboard")
    public String home(ModelMap modelMap){
        modelMap.addAttribute("countPro", productService.count());
        modelMap.addAttribute("countMemner", userSevice.count());
        return "dashboardCms";
    }

    @GetMapping("/user")
    public String listUser(ModelMap modelMap){
        AdminDTO adminDTO = new AdminDTO();
        modelMap.addAttribute("AdminDTO", adminDTO);
        modelMap.addAttribute("listAdmin", adminService.findAll());
//        modelMap.addAttribute("Action","/admin/user/insert");
        return "userCms";
    }

    @PostMapping("/user/insertOrUpdate")
    public String insert(ModelMap modelMap, @ModelAttribute("AdminDTO")AdminDTO dto, RedirectAttributes attributes){
        Integer id = dto.getId();
        String name = dto.getUserName();
        String email = dto.getEmail();
        String password = dto.getPassword();
        String phone = dto.getPhone();
        MultipartFile img = dto.getImage();
        String secretKey = "Aa@123";
        String pass = AES.encrypt(password, secretKey);
        Optional<Admin> optionalAdmin = adminService.findById(id);
        Optional<Admin> adminOptional = adminService.findAdminByEmail(email);
        String image = "logo2.jpg";
        Path path = Paths.get("uploads");
        if(optionalAdmin.isPresent()){
           try{
               image =img.getOriginalFilename().toString();
               if(image.equals("")){
                   image = optionalAdmin.get().getImage();
               } else {
                   InputStream inputStream = img.getInputStream();
                   Files.copy(inputStream, path.resolve(img.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
                   image =img.getOriginalFilename().toString();
               }
               Admin admin = new Admin(id, name, email, pass, phone, image);
               adminService.save(admin);
               attributes.addFlashAttribute("success", "Sửa thành công");
           } catch (Exception e) {
               attributes.addFlashAttribute("error", "Sửa thất bại");
           }
        }else {
            if (adminOptional.isPresent()){
                attributes.addFlashAttribute("error", "Email đã được đăng ký");
            } else {
                if (!img.isEmpty()){
                    try{
                        InputStream inputStream = img.getInputStream();
                        Files.copy(inputStream, path.resolve(img.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
                        image =img.getOriginalFilename().toString();
                        Admin admin = new Admin(name, email, pass, phone,  image);
                        adminService.save(admin);
                        attributes.addFlashAttribute("success", "Thêm thành công");
                    } catch (Exception e) {
                        attributes.addFlashAttribute("error", "Thêm thất bại");
                    }
                }
            }
        }
        return "redirect:/admin/user";
    }

    @RequestMapping("/user/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes attributes){
        adminService.deleteById(id);
        attributes.addFlashAttribute("success", "Xoá thành công");
        return "redirect:/admin/user";
    }
}
