package com.project.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.travel.entity.ItenaryEntity;

public interface ItenaryRepo extends JpaRepository<ItenaryEntity, Long>{
    
}
