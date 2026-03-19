package com.project.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.travel.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity,Long>{
    UserEntity findByEmail(String email);

    UserEntity findByEmailAndPasswordHash(String email, String passwordHash);
    
} 
