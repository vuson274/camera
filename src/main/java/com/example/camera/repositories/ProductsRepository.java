package com.example.camera.repositories;

import com.example.camera.model.Categories;
import com.example.camera.model.Products;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductsRepository extends CrudRepository<Products, Integer> {
    Iterable<Products> findAllByOrderByIdDesc();
    List<Products> findTop5ByOrderByIdDesc();
    List<Products> findTop5ByOrderByPriceDesc();
    List<Products> findTop5ByOrderByPriceAsc();
    List<Products> findTop8ByCategoryOrderByIdDesc(Categories categories);
}