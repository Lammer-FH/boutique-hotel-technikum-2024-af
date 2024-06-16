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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOKING_ID")
    private int bookingId;

    @ManyToOne
    @JoinColumn(name = "ROOM_ID_FK")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "GUEST_ID_FK")
    private Guest guest;

    @Column(name = "BOOKING_DATE_START")
    private LocalDateTime bookingStartTime;

    @Column(name = "BOOKING_DATE_END")
    private LocalDateTime bookingEndTime;

    @Column(name = "BREAKFAST")
    private boolean breakfast;
}
