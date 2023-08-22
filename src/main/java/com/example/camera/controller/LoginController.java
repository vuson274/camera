package com.example.camera.controller;

import com.example.camera.config.AES;
import com.example.camera.model.Admin;
import com.example.camera.model.User;
import com.example.camera.service.AdminService;
import com.example.camera.service.UserSevice;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.util.Optional;

@Controller
public class LoginController {
    @Autowired
    AdminService adminService;
    @Autowired
    UserSevice userSevice;
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

    @GetMapping("/login")
    public String Member(ModelMap modelMap){
        User user = new User();
        modelMap.addAttribute("user", user);
        return "login";
    }

    @PostMapping("/loginMember")
    public String loginMember(ModelMap modelMap, @RequestParam("email") String email, @RequestParam("password") String password, HttpSession session, RedirectAttributes attributes){
        String secretKey = "Aa@123";
        String pass1 = password.trim();
        String pass = AES.encrypt(pass1, secretKey);
        Optional<User> optionalUser  = userSevice.findUserByEmail(email);
        if (optionalUser.isPresent()) {
            if (!pass.equals(optionalUser.get().getPassword())){
                attributes.addFlashAttribute("message", "Email hoặc password không đúng");
            } else {
                session.setAttribute("member", optionalUser.get().getUserName());
                return "redirect:/home";
            }
        } else {
            attributes.addFlashAttribute("message", "Email hoặc password không đúng");
        }
        return "redirect:/login";
    }
    @GetMapping("/signUp")
    public String signUpMember(ModelMap modelMap){
        User user = new User();
        modelMap.addAttribute("user", user);
        return "signUp";
    }

    @PostMapping("/createMember")
    public String insertMember(ModelMap modelMap, @ModelAttribute("user") User user, RedirectAttributes attributes){
        String userName = user.getUserName();
        String fullName = user.getName();
        String email = user.getEmail();
        String password = user.getPassword();
        String phone = user.getPhone();
        String add = user.getAddress();
        Date birth = user.getDateOfBirth();
        Date creatAt = new Date(System.currentTimeMillis());
        String secretKey = "Aa@123";
        String pass = AES.encrypt(password, secretKey);
        Optional<User> optionalUser  = userSevice.findUserByEmail(email);
        try {
            if (optionalUser.isPresent()) {
                attributes.addFlashAttribute("noti", "Email đã được đăng ký");
            } else {
                User userMember = new User(userName, pass, fullName, email, phone, add, birth, creatAt);
                userSevice.save(userMember);
                attributes.addFlashAttribute("noti", "Đăng ký thành công");
            }
        } catch (Exception e) {
            attributes.addFlashAttribute("noti", "Đăng ký không thành công");
        }
        return "redirect:/signUp";
    }

    @GetMapping("/logoutMember")
    public String logoutMember(HttpSession session){
        session.removeAttribute("member");
        return "redirect:/home";
    }

}
