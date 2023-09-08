package com.example.camera.controller;

import com.example.camera.model.Category;
import com.example.camera.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class CategoryController {
   @Autowired
   CategoryService categoryService;
    @GetMapping("/admin/categories")
    public String listCategories(ModelMap modelMap){
        modelMap.addAttribute("categories", categoryService.findAll());
        return "categoriesCms";
    }
    @PostMapping("/admin/categories/insert")
    public String insertCategory(ModelMap modelMap, @ModelAttribute("category") Category categories , BindingResult bindingResult, RedirectAttributes attributes) {
        if (bindingResult.hasErrors()){
            return "redirect:/admin/categories" ;
        }
        try{
            categoryService.save(categories);
            attributes.addFlashAttribute("success", "Thêm thành công");
            return "redirect:/admin/categories" ;
        } catch (Exception e) {
            attributes.addFlashAttribute("error", "Thêm thất bại");
            return "redirect:/admin/categories" ;
        }
    }

    @PostMapping("/admin/categories/update")
    public String updateCategory(ModelMap modelMap, @ModelAttribute("categories") Category categories, RedirectAttributes attributes){
       try{
           modelMap.addAttribute("category",categories);
           categoryService.save(categories);
           attributes.addFlashAttribute("success", "Sửa thành công");
           return "redirect:/admin/categories" ;
       } catch (Exception e) {
           attributes.addFlashAttribute("error", "Sửa thất bại");
           return "redirect:/admin/categories" ;
       }
    }

}
