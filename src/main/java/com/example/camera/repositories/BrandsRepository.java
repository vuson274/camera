package com.example.camera.repositories;

import com.example.camera.model.Brands;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BrandsRepository extends JpaRepository<Brands, Integer> {
}
