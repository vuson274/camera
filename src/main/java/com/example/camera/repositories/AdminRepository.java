package com.example.camera.repositories;

import com.example.camera.model.Admin;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AdminRepository extends CrudRepository<Admin, Integer> {
    Optional<Admin> findAdminByEmail(String email);
}
