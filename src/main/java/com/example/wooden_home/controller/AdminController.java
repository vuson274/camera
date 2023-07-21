package com.example.wooden_home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {
    @Autowired
    @GetMapping("/login")
    public String login(){
        return "loginCms";
    }
    @GetMapping("")
    public String home(){
        return "dashboardCms";
    }

    @GetMapping("/user")
    public String user(ModelMap modelMap){
        return "userCms";
    }



}
