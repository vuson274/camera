package com.example.camera.service;

import com.example.camera.model.Category;
import com.example.camera.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoriesRepository;

    @Override
    public Category save(Category entity) {
        return categoriesRepository.save(entity);
    }

    @Override
    public List<Category> saveAll(List<Category> entities) {
        return (List<Category>) categoriesRepository.saveAll(entities);
    }

    @Override
    public Optional<Category> findById(Integer integer) {
        return categoriesRepository.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return categoriesRepository.existsById(integer);
    }

    @Override
    public Iterable<Category> findAll() {
        return categoriesRepository.findAll();
    }

    @Override
    public List<Category> findAllById(List<Integer> integers) {
        return (List<Category>) categoriesRepository.findAllById(integers);
    }

    @Override
    public long count() {
        return categoriesRepository.count();
    }

    @Override
    public void deleteById(Integer integer) {
        categoriesRepository.deleteById(integer);
    }

    @Override
    public void delete(Category entity) {
        categoriesRepository.delete(entity);
    }

    @Override
    public void deleteAllById(List<Integer> integers) {
        categoriesRepository.deleteAllById(integers);
    }

    @Override
    public void deleteAll(List<Category> entities) {
        categoriesRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        categoriesRepository.deleteAll();
    }
}
