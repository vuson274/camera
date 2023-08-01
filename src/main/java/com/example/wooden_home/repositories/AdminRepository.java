package com.example.wooden_home.repositories;

import com.example.wooden_home.model.Admin;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AdminRepository extends CrudRepository<Admin, Integer> {
    Optional<Admin> findAdminByEmail(String email);
}
