package com.project.travel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.travel.entity.ActivityEntity;
import com.project.travel.entity.DestinationEntity;
import com.project.travel.service.DestinationService;

@RestController
@RequestMapping("/api/destinations")
public class DestinationController {
    @Autowired
    private DestinationService destinationService;

    @GetMapping
    public List<DestinationEntity> getAllDestinations() {
        return destinationService.getAllDestinations();
    }

    @GetMapping("/{id}")
    public DestinationEntity getDestination(@PathVariable Long id) {
        return destinationService.getDestination(id);
    }

    @GetMapping("/{id}/activities")
    public List<ActivityEntity> getActivities(@PathVariable Long id) {
        return destinationService.getActivitiesByDestination(id);
    }

    @GetMapping("/search")
    public List<DestinationEntity> searchDestinations(@RequestParam String keyword) {
        return destinationService.search(keyword);
    }
}
