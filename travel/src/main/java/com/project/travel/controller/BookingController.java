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

import com.project.travel.entity.BookingEntity;

import com.project.travel.service.BookingService;



@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    
    @Autowired
    private BookingService bookingService;

    @PostMapping
    public BookingEntity createBooking(@RequestBody BookingEntity booking) {
        return bookingService.createBooking(booking);
    }

    @GetMapping("/itinerary/{itineraryId}")
    public List<BookingEntity> getBookingsByItinerary(@PathVariable Long itineraryId) {
        return bookingService.getBookingsByItinerary(itineraryId);
    }

    @PutMapping("/{id}")
    public BookingEntity updateBooking(@PathVariable Long id, @RequestBody BookingEntity booking) {
        return bookingService.updateBooking(id, booking);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
    }

    @GetMapping("/{id}/confirmation")
    public String getConfirmation(@PathVariable Long id) {
        return bookingService.getConfirmation(id);
    }

}
