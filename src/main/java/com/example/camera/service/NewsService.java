package com.example.camera.service;

import com.example.camera.model.News;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface NewsService {
    News save(News entity);

    List<News> saveAll(List<News> entities);

    Optional<News> findById(Integer integer);

    boolean existsById(Integer integer);

    Iterable<News> findAll(Pageable pageable);

    List<News> findAllById(List<Integer> integers);

    long count();

    void deleteById(Integer integer);

    void delete(News entity);

    void deleteAllById(List<Integer> integers);

    void deleteAll(List<News> entities);

    void deleteAll();

    List<News> findTop3ByOrderByCreateAtDesc();

    List<News> findAllByOrderByIdDesc();
}
