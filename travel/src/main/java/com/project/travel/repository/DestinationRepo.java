package com.project.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.travel.entity.DestinationEntity;

public interface DestinationRepo extends JpaRepository<DestinationEntity, Long>{
    
}
