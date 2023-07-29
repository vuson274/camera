package com.example.wooden_home.service;

import com.example.wooden_home.model.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    Admin save(Admin entity);

    List<Admin> saveAll(List<Admin> entities);

    Optional<Admin> findById(Integer integer);

    boolean existsById(Integer integer);

    Iterable<Admin> findAll();

    List<Admin> findAllById(List<Integer> integers);

    long count();

    void deleteById(Integer integer);

    void delete(Admin entity);

    void deleteAllById(List<Integer> integers);

    void deleteAll(List<Admin> entities);

    void deleteAll();
}
