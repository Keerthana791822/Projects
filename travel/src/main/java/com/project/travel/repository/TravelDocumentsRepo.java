package com.project.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.travel.entity.TravelDocumentsEntity;

public interface TravelDocumentsRepo extends JpaRepository<TravelDocumentsEntity,Long>{
    
}
