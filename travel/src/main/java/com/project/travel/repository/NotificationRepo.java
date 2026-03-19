package com.project.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.travel.entity.NotificationEntity;

public interface NotificationRepo extends JpaRepository<NotificationEntity , Long>{
    
}
