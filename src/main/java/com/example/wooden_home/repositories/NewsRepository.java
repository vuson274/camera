package com.example.wooden_home.repositories;

import com.example.wooden_home.model.News;
import org.springframework.data.repository.CrudRepository;

public interface NewsRepository extends CrudRepository<News, Integer> {
}
