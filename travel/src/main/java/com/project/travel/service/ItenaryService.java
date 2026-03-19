package com.project.travel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.travel.entity.ItenaryEntity;
import com.project.travel.repository.ItenaryRepo;

@Service
public class ItenaryService {
    
    @Autowired
    ItenaryRepo itineraryRepo;

    public ItenaryEntity createItinerary(ItenaryEntity itinerary) {
        return itineraryRepo.save(itinerary);
    }

    public List<ItenaryEntity> getAllItineraries() {
        return itineraryRepo.findAll();
    }

    public ItenaryEntity getItinerary(Long id) {
        return itineraryRepo.findById(id).orElse(null);
    }

    public ItenaryEntity updateItinerary(Long id, ItenaryEntity itinerary) {
        itinerary.setId(id);
        return itineraryRepo.save(itinerary);
    }

    public void deleteItinerary(Long id) {
        itineraryRepo.deleteById(id);
    }

    public String shareItinerary(Long id) {
        return "Itinerary " + id + " shared successfully!";
    }
}
