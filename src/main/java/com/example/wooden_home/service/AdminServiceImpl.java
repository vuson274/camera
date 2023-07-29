package com.example.wooden_home.service;

import com.example.wooden_home.dto.AdminDTO;
import com.example.wooden_home.model.Admin;
import com.example.wooden_home.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    AdminRepository adminRepository;

    @Override
    public Admin save(Admin entity) {
        return adminRepository.save(entity);
    }

    @Override
    public List<Admin> saveAll(List<Admin> entities) {
        return (List<Admin>) adminRepository.saveAll(entities);
    }

    @Override
    public Optional<Admin> findById(Integer integer) {
        return adminRepository.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return adminRepository.existsById(integer);
    }

    @Override
    public Iterable<Admin> findAll() {
        return adminRepository.findAll();
    }

    @Override
    public List<Admin> findAllById(List<Integer> integers) {
        return (List<Admin>) adminRepository.findAllById(integers);
    }

    @Override
    public long count() {
        return adminRepository.count();
    }

    @Override
    public void deleteById(Integer integer) {
        adminRepository.deleteById(integer);
    }

    @Override
    public void delete(Admin entity) {
        adminRepository.delete(entity);
    }

    @Override
    public void deleteAllById(List<Integer> integers) {
        adminRepository.deleteAllById(integers);
    }

    @Override
    public void deleteAll(List<Admin> entities) {
        adminRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        adminRepository.deleteAll();
    }

}
