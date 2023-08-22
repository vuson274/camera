package com.example.camera.service;

import com.example.camera.model.News;
import com.example.camera.repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsServiceImpl implements NewsService{
    @Autowired
    NewsRepository newsRepository;

    @Override
    public News save(News entity) {
        return newsRepository.save(entity);
    }

    @Override
    public List<News> saveAll(List<News> entities) {
        return (List<News>) newsRepository.saveAll(entities);
    }

    @Override
    public Optional<News> findById(Integer integer) {
        return newsRepository.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return newsRepository.existsById(integer);
    }

    @Override
    public Iterable<News> findAll(Pageable pageable) {
        return newsRepository.findAll(pageable);
    }

    @Override
    public List<News> findAllById(List<Integer> integers) {
        return (List<News>) newsRepository.findAllById(integers);
    }

    @Override
    public long count() {
        return newsRepository.count();
    }

    @Override
    public void deleteById(Integer integer) {
        newsRepository.deleteById(integer);
    }

    @Override
    public void delete(News entity) {
        newsRepository.delete(entity);
    }

    @Override
    public void deleteAllById(List<Integer> integers) {
        newsRepository.deleteAllById(integers);
    }

    @Override
    public void deleteAll(List<News> entities) {
        newsRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        newsRepository.deleteAll();
    }

    @Override
    public List<News> findTop3ByOrderByCreateAtDesc() {
        return newsRepository.findTop3ByOrderByCreateAtDesc();
    }

    @Override
    public List<News> findAllByOrderByIdDesc() {
        return newsRepository.findAllByOrderByIdDesc();
    }
}
