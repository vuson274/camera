package com.example.camera.service;

import com.example.camera.model.Brand;
import com.example.camera.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandRepository brandsRepository;

    @Override
    public Brand save(Brand entity) {
        return brandsRepository.save(entity);
    }

    @Override
    public List<Brand> saveAll(List<Brand> entities) {
        return (List<Brand>) brandsRepository.saveAll(entities);
    }

    @Override
    public Optional<Brand> findById(Integer integer) {
        return brandsRepository.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return brandsRepository.existsById(integer);
    }

    @Override
    public Iterable<Brand> findAll() {
        return brandsRepository.findAll();
    }

    @Override
    public List<Brand> findAllById(List<Integer> integers) {
        return (List<Brand>) brandsRepository.findAllById(integers);
    }

    @Override
    public long count() {
        return brandsRepository.count();
    }

    @Override
    public void deleteById(Integer integer) {
        brandsRepository.deleteById(integer);
    }

    @Override
    public void delete(Brand entity) {
        brandsRepository.delete(entity);
    }

    @Override
    public void deleteAllById(List<Integer> integers) {
        brandsRepository.deleteAllById(integers);
    }

    @Override
    public void deleteAll(List<Brand> entities) {
        brandsRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        brandsRepository.deleteAll();
    }
}
