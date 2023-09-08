package com.example.camera.repositories;

import com.example.camera.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Optional<Admin> findAdminByEmail(String email);
}
