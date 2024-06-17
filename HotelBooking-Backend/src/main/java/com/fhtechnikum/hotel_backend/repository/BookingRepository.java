package com.fhtechnikum.hotel_backend.repository;

import com.fhtechnikum.hotel_backend.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    @Query(value =
            "SELECT * " +
            "FROM BOOKING " +
            "WHERE ROOM_ID_FK = ?1 AND ?3 > BOOKING_DATE_START AND ?2 < BOOKING.BOOKING_DATE_END " +
            "ORDER BY BOOKING_DATE_END DESC ", nativeQuery = true)
    Iterable<Booking> findByOverlappingDates(int roomId, LocalDateTime startDateTime, LocalDateTime endDateTime);
}
