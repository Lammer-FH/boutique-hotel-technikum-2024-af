package com.fhtechnikum.hotel_backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "BOOKING")
@Table(name = "BOOKING")
@Getter
@Setter
@NoArgsConstructor
public class Booking {
    @Id
    @Column(name = "BOOKING_ID")
    private int bookingId;

    @Column(name = "ROOM_ID_FK")
    private int roomId;

    @Column(name = "GUEST_ID_FK")
    private int guestId;

    @Column(name = "BOOKING_DATE_START")
    private LocalDateTime startTime;

    @Column(name = "BOOKING_DATE_END")
    private LocalDateTime endTime;

    @Column(name = "BREAKFAST")
    private boolean breakfast;
}
