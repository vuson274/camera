package com.example.camera.controller;

import com.example.camera.model.Customer;
import com.example.camera.model.Product;
import com.example.camera.service.CategoryService;
import com.example.camera.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @GetMapping("/home")
    public String home(ModelMap modelMap, @RequestParam("p") Optional<Integer> p){
        Pageable pageable = PageRequest.of(p.orElse(0), 20, Sort.by("id").descending());
        Page<Product> page = (Page<Product>) productService.findAll(pageable);
        modelMap.addAttribute("listCategories", categoryService.findAll());
        modelMap.addAttribute("page",Math.ceil(productService.count()/20));
        modelMap.addAttribute("listProducts", page);
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
    public String shop(ModelMap modelMap, @RequestParam("p") Optional<Integer> p){
        modelMap.addAttribute("page",Math.ceil(productService.count()/20));
        Pageable pageable = PageRequest.of(p.orElse(0), 20, Sort.by("id").descending());
        Page<Product> page = (Page<Product>) productService.findAll(pageable);
        modelMap.addAttribute("listProducts", page);
        modelMap.addAttribute("listCategories", categoryService.findAll());
        return "shop";
    }

    @GetMapping("/warranty")
    public String warranty(){
        return "warranty";
    }

    @GetMapping("/favoriteList")
    public String favoriteProduct(){
        return "favoriteList";
    }

    @GetMapping("/shopCart")
    public String shopCart(){
        return "shopCart";
    }

    @GetMapping("/checkout")
    public String checkout(){
        return "checkOut";
    }

}
