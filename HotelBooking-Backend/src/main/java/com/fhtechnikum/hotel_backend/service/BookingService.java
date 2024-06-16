package com.fhtechnikum.hotel_backend.service;

import com.fhtechnikum.hotel_backend.model.Booking;
import com.fhtechnikum.hotel_backend.model.RoomAvailability;
import com.fhtechnikum.hotel_backend.repository.BookingRepository;
import com.fhtechnikum.hotel_backend.repository.GuestRepository;
import com.fhtechnikum.hotel_backend.repository.RoomRepository;
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
    @Autowired
    private RoomRepository roomRepository;

    public Iterable<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(int id) {
        return bookingRepository.findById(id);
    }

    public Optional<Booking> insertBooking(Booking booking) {
        booking.setBookingId(0);
        booking.getGuest().setGuestId(0);

        var targetRoom = roomRepository.findById(booking.getRoom().getRoomId());

        if (targetRoom.isEmpty()) {
            System.out.println("Tried to book non existing room: " + booking.getRoom().getRoomId());
            return Optional.empty();
        }

        var roomAvailability = getRoomAvailability(targetRoom.get().getRoomId(), booking.getBookingStartTime(), booking.getBookingEndTime());

        if (!roomAvailability.isRoomIsAvailable()) {
            System.out.println("Tried to book unavailable room: " + targetRoom.get().getRoomId());
            return Optional.empty();
        }

        var existingGuest = guestRepository.findByGuestEmail(booking.getGuest().getGuestEmail());

        if (existingGuest.isPresent()) {
            booking.setGuest(existingGuest.get());
        } else {
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
        return room.map((r) -> new RoomAvailability(false, r.getBookingEndTime()))
                .orElseGet(() -> new RoomAvailability(true, null));
    }
}
