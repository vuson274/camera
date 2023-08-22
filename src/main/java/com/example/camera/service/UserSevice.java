package com.example.camera.service;

import com.example.camera.model.User;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface UserSevice {
    User save(User entity);

    List<User> saveAll(List<User> entities);

    Optional<User> findById(Integer integer);

    boolean existsById(Integer integer);

    Iterable<User> findAll();

    List<User> findAllById(List<Integer> integers);

    long count();

    void deleteById(Integer integer);

    void delete(User entity);

    void deleteAllById(List<Integer> integers);

    void deleteAll(List<User> entities);

    void deleteAll();

    Optional<User> findUserByEmail(String email);

    List<User> findUserByCreateAtBetween(Date from_date, Date to_date);
}
