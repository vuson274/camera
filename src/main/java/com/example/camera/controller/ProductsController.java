package com.example.camera.controller;

import com.example.camera.dto.ProductsDTO;
import com.example.camera.model.Brands;
import com.example.camera.model.Categories;
import com.example.camera.model.Products;
import com.example.camera.service.BrandService;
import com.example.camera.service.CategoryService;
import com.example.camera.service.ProductService;
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
import java.sql.Date;
import java.util.Optional;

@Controller
public class ProductsController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    BrandService brandService;
    @GetMapping("/admin/product")
    public String listProducts(ModelMap modelMap){
        modelMap.addAttribute("listProducts", productService.findAllByOrderByIdDesc());
        return "productCms";
    }

    @GetMapping("/product/create")
    public String addProduct(ModelMap modelMap){
        ProductsDTO productsDTO = new ProductsDTO();
        modelMap.addAttribute("Categories", categoryService.findAll());
        modelMap.addAttribute("Brands", brandService.findAll());
        modelMap.addAttribute("ProductsDTO", productsDTO);
        return "addProduct";
    }

    @GetMapping("/editproduct/{id}")
    public String editProduct(ModelMap modelMap, @PathVariable Integer id){
        Optional<Products> productsOptional = productService.findById(id);
        ProductsDTO productsDTO = null;
        if(productsOptional.isPresent()){
            Products products = productsOptional.get();
            modelMap.addAttribute("ProductsDTO", products);
        } else {
            modelMap.addAttribute("ProductsDTO", new Products());
        }
        modelMap.addAttribute("Categories", categoryService.findAll());
        modelMap.addAttribute("Brands", brandService.findAll());
        return "editProduct";
    }

    @PostMapping("/admin/product/insertOrUpdate")
    public String insert(ModelMap modelMap, @ModelAttribute("ProductsDTO") ProductsDTO dto, RedirectAttributes attributes){
        Integer id = dto.getId();
        Categories category = dto.getCategory();
        Brands brand = dto.getBrand();
        String name = dto.getName();
        String origin = dto.getOrigin();
        MultipartFile mainImg = dto.getMainImage();
        MultipartFile secondImg = dto.getSecondImage();
        Float price = dto.getPrice();
        Integer quantity = dto.getQuantity();
        String description = dto.getDescription();
        Integer sale = dto.getSale();
        Float salePrice = price - (price*sale)/100;
        Date creatAt = new Date(System.currentTimeMillis());
        Optional<Products> optionalProduct = productService.findById(id);
        String mainImage = "logo2.jpg";
        String secondImage = "logo2.jpg";
        Path path = Paths.get("uploads");
        if(optionalProduct.isPresent()){
            try{
                mainImage = mainImg.getOriginalFilename().toString();
                secondImage = secondImg.getOriginalFilename().toString();
                if(mainImage.equals("")){
                    mainImage = optionalProduct.get().getMainImage();
                } else {
                    InputStream inputStream = mainImg.getInputStream();
                    Files.copy(inputStream, path.resolve(mainImg.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
                    mainImage =mainImg.getOriginalFilename().toString();
                }
                if(secondImage.equals("")){
                    secondImage = optionalProduct.get().getMainImage();
                } else {
                    InputStream inputStream = secondImg.getInputStream();
                    Files.copy(inputStream, path.resolve(secondImg.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
                    secondImage =secondImg.getOriginalFilename().toString();
                }
                Products product = new Products(id, category, brand, name, origin, mainImage, secondImage, price, quantity, description, sale, salePrice, creatAt);
                productService.save(product);
                attributes.addFlashAttribute("success", "Sửa thành công");
            } catch (Exception e) {
                attributes.addFlashAttribute("error", "Sửa thất bại");
            }
        } else {
            if (!mainImg.isEmpty() && !secondImg.isEmpty()){
                try{
                    InputStream inputStreamMain = mainImg.getInputStream();
                    InputStream inputStreamSecond = secondImg.getInputStream();
                    Files.copy(inputStreamMain, path.resolve(mainImg.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
                    Files.copy(inputStreamSecond, path.resolve(secondImg.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
                    mainImage = mainImg.getOriginalFilename().toString();
                    secondImage = secondImg.getOriginalFilename().toString();
                    Products product = new Products(category, brand, name, origin, mainImage, secondImage, price, quantity, description, sale, salePrice, creatAt);
                    productService.save(product);
                    attributes.addFlashAttribute("success", "Thêm thành công");
                } catch (Exception e) {
                    attributes.addFlashAttribute("error", "Thêm thất bại");
                }
            }
        }
        return "redirect:/admin/product";
    }
}
