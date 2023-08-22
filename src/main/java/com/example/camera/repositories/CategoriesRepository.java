package com.example.camera.repositories;

import com.example.camera.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CategoriesRepository extends JpaRepository<Categories, Integer> {
}
