package com.example.wooden_home.repositories;

import com.example.wooden_home.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
