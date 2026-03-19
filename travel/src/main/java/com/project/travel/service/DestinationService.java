package com.project.travel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.travel.entity.ActivityEntity;
import com.project.travel.entity.DestinationEntity;
import com.project.travel.repository.ActivityRepo;
import com.project.travel.repository.DestinationRepo;

@Service
public class DestinationService {
    @Autowired
    private DestinationRepo destinationRepo;

    @Autowired
    private ActivityRepo activityRepo;

    public List<DestinationEntity> getAllDestinations() {
        return destinationRepo.findAll();
    }

    public DestinationEntity getDestination(Long id) {
        return destinationRepo.findById(id).orElse(null);
    }

    public List<ActivityEntity> getActivitiesByDestination(Long id) {
        return activityRepo.findAll().stream()
                .filter(a -> a.getDestination() != null && a.getDestination().getId().equals(id))
                .toList();
    }

    public List<DestinationEntity> search(String keyword) {
        return destinationRepo.findAll().stream()
                .filter(d -> d.getName().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
    }
}
