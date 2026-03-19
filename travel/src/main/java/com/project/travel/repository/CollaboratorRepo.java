package com.project.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.travel.entity.CollaboratorEntity;

public interface CollaboratorRepo extends JpaRepository<CollaboratorEntity,Long>{
    
}
