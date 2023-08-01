package com.example.wooden_home.service;

import com.example.wooden_home.model.News;
import com.example.wooden_home.repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Iterable<News> findAll() {
        return newsRepository.findAll();
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
}
