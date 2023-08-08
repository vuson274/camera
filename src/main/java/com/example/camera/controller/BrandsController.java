package com.example.camera.controller;

import com.example.camera.model.Brands;
import com.example.camera.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BrandsController {
    @Autowired
    BrandService brandService;

    @GetMapping("/admin/brands")
    public String listBrands(ModelMap modelMap) {
        modelMap.addAttribute("brands", brandService.findAll());
        return "brandCms";
    }

    @PostMapping("/admin/brands/insert")
    public String insertBrand(ModelMap modelMap, @ModelAttribute("brand") Brands brands, BindingResult bindingResult, RedirectAttributes attributes) {
        if (bindingResult.hasErrors()) {
            return "redirect:/admin/brands";
        }
        try {
            brandService.save(brands);
            attributes.addFlashAttribute("success", "Thêm thành công");
            return "redirect:/admin/brands";
        } catch (Exception e) {
            attributes.addFlashAttribute("error", "Thêm thất bại");
            return "redirect:/admin/brands";
        }
    }

    @PostMapping("/admin/brands/update")
    public String updateCategory(ModelMap modelMap, @ModelAttribute("brands") Brands brands, RedirectAttributes attributes){
        try{
            modelMap.addAttribute("brand",brands);
            brandService.save(brands);
            attributes.addFlashAttribute("success", "Sửa thành công");
            return "redirect:/admin/brands" ;
        } catch (Exception e) {
            attributes.addFlashAttribute("error", "Sửa thất bại");
            return "redirect:/admin/brands" ;
        }
    }
}