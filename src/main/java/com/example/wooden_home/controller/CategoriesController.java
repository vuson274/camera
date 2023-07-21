package com.example.wooden_home.controller;

import com.example.wooden_home.model.Categories;
import com.example.wooden_home.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.util.Optional;


@Controller
public class CategoriesController {
   @Autowired
    private CategoriesRepository categoriesRepository;
    @GetMapping("/admin/categories")
    public String listCategories(ModelMap modelMap){
        modelMap.addAttribute("categories", categoriesRepository.findAll());
        return "categoriesCms";
    }
    @PostMapping("/admin/categories/insert")
    public String insertCategory(ModelMap modelMap, @ModelAttribute("category") Categories categories , BindingResult bindingResult, RedirectAttributes attributes) {
        if (bindingResult.hasErrors()){
            return "redirect:/admin/categories" ;
        }
        try{
            categoriesRepository.save(categories);
            attributes.addFlashAttribute("success", "Thêm thành công");
            return "redirect:/admin/categories" ;
        } catch (Exception e) {
            attributes.addFlashAttribute("error", "Thêm thất bại");
            return "redirect:/admin/categories" ;
        }
    }

    @PostMapping("/admin/categories/update")
    public String updateCategory(ModelMap modelMap, @ModelAttribute("categories") Categories categories, RedirectAttributes attributes){
       try{
           modelMap.addAttribute("category",categories);
           categoriesRepository.save(categories);
           attributes.addFlashAttribute("success", "Thêm thành công");
           return "redirect:/admin/categories" ;
       } catch (Exception e) {
           attributes.addFlashAttribute("error", "Thêm thất bại");
           return "redirect:/admin/categories" ;
       }
    }

}
