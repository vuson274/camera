package com.example.camera.controller;

import com.example.camera.service.CategoryService;
import com.example.camera.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @GetMapping("/home")
    public String home(ModelMap modelMap){
        modelMap.addAttribute("listCategories", categoryService.findAll());
        modelMap.addAttribute("listProducts", productService.findAllByOrderByIdDesc());
        modelMap.addAttribute("listProductsNew", productService.findTop5ByOrderByIdDesc());
        modelMap.addAttribute("listProductsHot", productService.findTop5ByOrderByPriceAsc());
        modelMap.addAttribute("listProductsHightclass", productService.findTop5ByOrderByPriceDesc());
        return "home";
    }

    @RequestMapping("/product/{id}")
    public String productDetail(ModelMap modelMap,@PathVariable Integer id){
        modelMap.addAttribute("productDetail", productService.findById(id));
        modelMap.addAttribute("listRelateProduct", productService.findTop8ByCategoryOrderByIdDesc(productService.findById(id).get().getCategory()));
        return "productDetail";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

    @GetMapping("/shop")
    public String shop(ModelMap modelMap){
        modelMap.addAttribute("listProducts", productService.findAllByOrderByIdDesc());
        modelMap.addAttribute("listCategories", categoryService.findAll());
        return "shop";
    }
}
