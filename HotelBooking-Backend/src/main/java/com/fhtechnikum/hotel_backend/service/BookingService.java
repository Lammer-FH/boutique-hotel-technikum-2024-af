package com.fhtechnikum.hotel_backend.service;

import com.fhtechnikum.hotel_backend.model.Booking;
import com.fhtechnikum.hotel_backend.model.RoomAvailability;
import com.fhtechnikum.hotel_backend.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public Iterable<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(int id) {
        return bookingRepository.findById(id);
    }

    public RoomAvailability getRoomAvailability(int roomId, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        var room = bookingRepository.findByOverlappingDates(roomId, startDateTime, endDateTime);
        return room.map((r) -> new RoomAvailability(false, r.getEndTime()))
                .orElseGet(() -> new RoomAvailability(true, null));
    }
}
