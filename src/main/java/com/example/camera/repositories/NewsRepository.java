package com.example.camera.repositories;

import com.example.camera.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Integer> {
    List<News> findAllByOrderByIdDesc();
    List<News> findTop3ByOrderByCreateAtDesc();
}
