package com.project.travel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.travel.entity.ItenaryEntity;
import com.project.travel.service.ItenaryService;

@RestController
@RequestMapping("/api/itineraries")
public class Itenarycontroller {
    @Autowired
    ItenaryService itineraryService;

    @PostMapping
    public ItenaryEntity createItinerary(@RequestBody ItenaryEntity itinerary) {
        return itineraryService.createItinerary(itinerary);
    }

    @GetMapping
    public List<ItenaryEntity> getItineraries() {
        return itineraryService.getAllItineraries();
    }

    @GetMapping("/{id}")
    public ItenaryEntity getItinerary(@PathVariable Long id) {
        return itineraryService.getItinerary(id);
    }

    @PutMapping("/{id}")
    public ItenaryEntity updateItinerary(@PathVariable Long id, @RequestBody ItenaryEntity itinerary) {
        return itineraryService.updateItinerary(id, itinerary);
    }

    @DeleteMapping("/{id}")
    public void deleteItinerary(@PathVariable Long id) {
        itineraryService.deleteItinerary(id);
    }

    @PostMapping("/{id}/share")
    public String shareItinerary(@PathVariable Long id) {
        return itineraryService.shareItinerary(id);
    }
}
