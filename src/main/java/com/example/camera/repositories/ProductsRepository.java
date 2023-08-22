package com.example.camera.repositories;

import com.example.camera.model.Categories;
import com.example.camera.model.Products;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface ProductsRepository extends JpaRepository<Products, Integer> {
    Iterable<Products> findAllByOrderByIdDesc();
    List<Products> findTop5ByOrderByIdDesc();
    List<Products> findTop5ByOrderByPriceDesc();
    List<Products> findTop5ByOrderByPriceAsc();
    List<Products> findTop8ByCategoryOrderByIdDesc(Categories categories);
    List<Products> findByNameLike(String name);
    List<Products> findByCreateAtBetween(Date from_date, Date to_date);
    @Query(nativeQuery = true, value = "SELECT * FROM products  ORDER BY id DESC LIMIT :from, 20")
    List<Products> findByProOrderByIdDesc(Integer from);
}