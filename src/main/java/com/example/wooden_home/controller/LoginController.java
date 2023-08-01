package com.example.wooden_home.controller;

import com.example.wooden_home.config.AES;
import com.example.wooden_home.model.Admin;
import com.example.wooden_home.service.AdminService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class LoginController {
    @Autowired
    AdminService adminService;
    @GetMapping("/admin")
    public String viewForm(){
        return "loginCms";
    }

    @PostMapping("/admin/login")
    public String login(ModelMap model, @RequestParam("email") String email, @RequestParam("password") String password, HttpSession session, RedirectAttributes attributes){
        String secretKey = "Aa@123";
        String pass1 = password.trim();
        String pass = AES.encrypt(pass1, secretKey);
        Optional<Admin> optionalAdmin = adminService.findAdminByEmail(email);
        if (optionalAdmin.isPresent()){
            if(!pass.equals(optionalAdmin.get().getPassword())){
                attributes.addFlashAttribute("message", "Email hoặc password không đúng");
            } else{
                session.setAttribute("User", optionalAdmin.get().getUserName());
                return "redirect:/admin/dashboard";
            }
        }else {
            attributes.addFlashAttribute("message", "Email hoặc password không đúng");
        }
        return "redirect:/admin";
    }

    @GetMapping("/admin/logout")
    public String logout(HttpSession session){
        session.removeAttribute("User");
        return "redirect:/admin";
    }

}
