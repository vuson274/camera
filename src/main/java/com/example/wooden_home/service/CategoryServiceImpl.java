package com.example.wooden_home.service;

import com.example.wooden_home.model.Categories;
import com.example.wooden_home.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoriesRepository categoriesRepository;

    @Override
    public Categories save(Categories entity) {
        return categoriesRepository.save(entity);
    }

    @Override
    public List<Categories> saveAll(List<Categories> entities) {
        return (List<Categories>) categoriesRepository.saveAll(entities);
    }

    @Override
    public Optional<Categories> findById(Integer integer) {
        return categoriesRepository.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return categoriesRepository.existsById(integer);
    }

    @Override
    public Iterable<Categories> findAll() {
        return categoriesRepository.findAll();
    }

    @Override
    public List<Categories> findAllById(List<Integer> integers) {
        return (List<Categories>) categoriesRepository.findAllById(integers);
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
    public void delete(Categories entity) {
        categoriesRepository.delete(entity);
    }

    @Override
    public void deleteAllById(List<Integer> integers) {
        categoriesRepository.deleteAllById(integers);
    }

    @Override
    public void deleteAll(List<Categories> entities) {
        categoriesRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        categoriesRepository.deleteAll();
    }
}
