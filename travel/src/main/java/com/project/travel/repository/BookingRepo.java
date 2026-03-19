package com.project.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.travel.entity.BookingEntity;

public interface BookingRepo extends JpaRepository<BookingEntity,Long>{
    
}
