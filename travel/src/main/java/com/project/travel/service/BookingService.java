package com.project.travel.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.travel.entity.BookingEntity;
import com.project.travel.repository.BookingRepo;

@Service
public class BookingService {
    
    @Autowired
    private BookingRepo bookingRepo;

    public BookingEntity createBooking(BookingEntity booking) {
        return bookingRepo.save(booking);
    }

    public List<BookingEntity> getBookingsByItinerary(Long itineraryId) {
        return bookingRepo.findAll().stream()
                .filter(b -> b.getBookingReference() != null && b.getBookingReference().contains(itineraryId.toString()))
                .toList();
    }

    public BookingEntity updateBooking(Long id, BookingEntity updated) {
        BookingEntity existing = bookingRepo.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setBookingType(updated.getBookingType());
        existing.setBookingReference(updated.getBookingReference());
        existing.setProviderName(updated.getProviderName());
        existing.setServiceDate(updated.getServiceDate());
        existing.setCost(updated.getCost());
        existing.setCurrency(updated.getCurrency());
        existing.setStatus(updated.getStatus());
        existing.setConfirmationDetails(updated.getConfirmationDetails());
        existing.setNotes(updated.getNotes());

        return bookingRepo.save(existing);
    }

    public void deleteBooking(Long id) {
        bookingRepo.deleteById(id);
    }

    public String getConfirmation(Long id) {
        BookingEntity booking = bookingRepo.findById(id).orElse(null);
        if (booking == null) return "Booking not found!";
        return "Booking " + id + " is " + booking.getStatus();
    }
}
