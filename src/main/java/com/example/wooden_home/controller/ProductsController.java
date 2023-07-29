package com.example.wooden_home.controller;

import com.example.wooden_home.dto.ProductsDTO;
import com.example.wooden_home.model.Brands;
import com.example.wooden_home.model.Categories;
import com.example.wooden_home.model.Products;
import com.example.wooden_home.service.BrandService;
import com.example.wooden_home.service.CategoryService;
import com.example.wooden_home.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping(path = "/admin")
public class ProductsController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    BrandService brandService;
    @GetMapping("/product")
    public String listProducts(ModelMap modelMap){
        ProductsDTO productsDTO = new ProductsDTO();
        modelMap.addAttribute("Categories", categoryService.findAll());
        modelMap.addAttribute("Brands", brandService.findAll());
        modelMap.addAttribute("ProductsDTO", productsDTO);
        modelMap.addAttribute("listProducts", productService.findAll());
        return "productCms";
    }


    @PostMapping("/product/insertOrUpdate")
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
        String mainImage = "logo1.jpg";
        String secondImage = "logo1.jpg";
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
                attributes.addFlashAttribute("success", "Thêm thành công");
            } catch (Exception e) {
                attributes.addFlashAttribute("error", "Thêm thất bại");
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
