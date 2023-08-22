package com.example.camera.controller;

import com.example.camera.model.Products;
import com.example.camera.service.ProductService;
import com.example.camera.service.UserSevice;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
public class AjaxController {
    @Autowired
    ProductService productService;
    @Autowired
    UserSevice userSevice;
    @GetMapping("/productDetail")
    public  ResponseEntity<Products> detailProduct(@RequestParam("id") Integer id){
        Optional<Products> product = productService.findById(id);
        String name = product.get().getName();
        String mainImage = product.get().getMainImage();
        Float price = product.get().getPrice();
        Float salePrice = product.get().getSalePrice();
        String des = product.get(). getDescription();
        Products detailProduct = new Products(id, name, mainImage, price, des, salePrice);
        return  new ResponseEntity<>(detailProduct, HttpStatus.OK);
    }

    @GetMapping("/searchProduct")
    public  ResponseEntity<List<Products>> searchProduct(@RequestParam("name") String name){
        List<Products> products = productService.findByNameLike(name);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/likeProduct")
        public ResponseEntity<Products> likeProduct(ModelMap modelMap, @RequestParam("id") Integer id, HttpSession session){
        HashMap<Integer, Products> likeItems = (HashMap<Integer, Products>) session.getAttribute("myLikeItems");
        if (likeItems  == null){
            likeItems = new HashMap<>();
        }
        Products likeProduct = productService.findById(id).get();
        if(likeProduct != null){
            if (!likeItems.containsKey(id)){
                likeItems.put(id,likeProduct);
            }
        }
        session.setAttribute("myLikeItems", likeItems);
        session.setAttribute("myLikeNum", likeItems.size());
        return new ResponseEntity<>(likeProduct, HttpStatus.OK);
    }

    @GetMapping("/admin/filter")
    public ResponseEntity<List<Integer>> filter(@RequestParam("from_date") Date from_date, @RequestParam("to_date") Date to_date){
        Integer countPro = productService.findByCreateAtBetween(from_date, to_date).size();
        Integer countUser = userSevice.findUserByCreateAtBetween(from_date, to_date).size();
        List<Integer> count = new ArrayList<>();
        count.add(countPro);
        count.add(countUser);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }



}
