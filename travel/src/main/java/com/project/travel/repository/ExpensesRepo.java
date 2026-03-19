package com.project.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.travel.entity.ExpensesEntity;

public interface ExpensesRepo extends JpaRepository<ExpensesEntity,Long>{
    
}
