package com.fhtechnikum.hotel_backend.service;

import com.fhtechnikum.hotel_backend.model.Booking;
import com.fhtechnikum.hotel_backend.model.RoomAvailability;
import com.fhtechnikum.hotel_backend.repository.BookingRepository;
import com.fhtechnikum.hotel_backend.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private GuestRepository guestRepository;

    public Iterable<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(int id) {
        return bookingRepository.findById(id);
    }

    public Optional<Booking> insertBooking(Booking booking) {
        booking.setBookingId(0);
        booking.getGuest().setGuestId(0);

        var existingGuest = guestRepository.findByGuestEmail(booking.getGuest().getGuestEmail());

        if (existingGuest.isEmpty()) {
            guestRepository.save(booking.getGuest());
        }

        try {
            booking = bookingRepository.saveAndFlush(booking);
        } catch (DataAccessException e) {
            System.out.println("Failed to insert booking: " + e.getMessage());
            return Optional.empty();
        }

        return Optional.of(booking);
    }

    public RoomAvailability getRoomAvailability(int roomId, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        var room = bookingRepository.findByOverlappingDates(roomId, startDateTime, endDateTime);
        return room.map((r) -> new RoomAvailability(false, r.getEndTime()))
                .orElseGet(() -> new RoomAvailability(true, null));
    }
}
