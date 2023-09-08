package com.example.camera.repositories;

import com.example.camera.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByEmail(String email);
    List<User> findUserByCreateAtBetween(Date from_date, Date to_date);
}
