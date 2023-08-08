package com.example.camera.repositories;

import com.example.camera.model.News;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NewsRepository extends CrudRepository<News, Integer> {
    List<News> findTop3ByOrderByCreateAtDesc();
}
