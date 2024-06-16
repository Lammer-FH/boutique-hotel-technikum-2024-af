package com.fhtechnikum.hotel_backend.repository;

import com.fhtechnikum.hotel_backend.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    @Query(value = "SELECT * FROM BOOKING WHERE ROOM_ID_FK = ?1 AND ?2 BETWEEN BOOKING_DATE_START AND BOOKING_DATE_END OR ?3 BETWEEN BOOKING_DATE_START AND BOOKING_DATE_END", nativeQuery = true)
    Optional<Booking> findByOverlappingDates(int roomId, LocalDateTime startDateTime, LocalDateTime endDateTime);
}
