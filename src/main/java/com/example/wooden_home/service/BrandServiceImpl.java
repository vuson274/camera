package com.example.wooden_home.service;

import com.example.wooden_home.model.Brands;
import com.example.wooden_home.repositories.BrandsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService{
    @Autowired
    BrandsRepository brandsRepository;

    @Override
    public  Brands save(Brands entity) {
        return brandsRepository.save(entity);
    }

    @Override
    public List<Brands> saveAll(List<Brands> entities) {
        return (List<Brands>) brandsRepository.saveAll(entities);
    }

    @Override
    public Optional<Brands> findById(Integer integer) {
        return brandsRepository.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return brandsRepository.existsById(integer);
    }

    @Override
    public Iterable<Brands> findAll() {
        return brandsRepository.findAll();
    }

    @Override
    public List<Brands> findAllById(List<Integer> integers) {
        return (List<Brands>) brandsRepository.findAllById(integers);
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
    public void delete(Brands entity) {
        brandsRepository.delete(entity);
    }

    @Override
    public void deleteAllById(List<Integer> integers) {
        brandsRepository.deleteAllById(integers);
    }

    @Override
    public void deleteAll(List<Brands> entities) {
        brandsRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        brandsRepository.deleteAll();
    }
}
