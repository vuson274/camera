package com.example.camera.repositories;

import com.example.camera.model.Categories;
import org.springframework.data.repository.CrudRepository;

public interface CategoriesRepository extends CrudRepository<Categories, Integer> {
}
