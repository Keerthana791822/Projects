package com.project.travel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.travel.entity.SessionEntity;

public interface SessionRepo extends JpaRepository<SessionEntity,Long>{

    List<SessionEntity> findByUserIdAndIsActiveTrue(Long id);
    
}
