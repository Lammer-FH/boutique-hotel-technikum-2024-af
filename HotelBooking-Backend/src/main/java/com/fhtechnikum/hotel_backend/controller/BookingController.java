package com.fhtechnikum.hotel_backend.controller;

import com.fhtechnikum.hotel_backend.model.Booking;
import com.fhtechnikum.hotel_backend.model.RoomAvailability;
import com.fhtechnikum.hotel_backend.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping(path = "")
    public Iterable<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping(path = "/{bookingId}")
    public Optional<Booking> getBookingById(@PathVariable int bookingId) {
        return bookingService.getBookingById(bookingId);
    }

    @PostMapping(path = "")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        return bookingService.insertBooking(booking)
                .map(createdBooking -> new ResponseEntity<>(booking, HttpStatus.CREATED))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping(path = "")
    public ResponseEntity<RoomAvailability> getRoomAvailability(
            @RequestParam int roomId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        return ResponseEntity.ok(bookingService.getRoomAvailability(roomId, startDate, endDate));
    }
}
