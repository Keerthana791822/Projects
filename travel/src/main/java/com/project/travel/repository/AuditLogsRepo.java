package com.project.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.travel.entity.AuditLogsEntity;

public interface AuditLogsRepo extends JpaRepository<AuditLogsEntity , Long>{
    
}
