package com.project.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.travel.entity.ActivityEntity;

public interface ActivityRepo extends JpaRepository<ActivityEntity,Long>{
    
}
