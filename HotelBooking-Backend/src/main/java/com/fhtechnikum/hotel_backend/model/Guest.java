package com.fhtechnikum.hotel_backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "GUEST")
@Table(name = "GUEST")
@Getter
@Setter
@NoArgsConstructor
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GUEST_ID")
    private int guestId;

    @Column(name = "GUEST_NAME")
    private String guestName;

    @Column(name = "GUEST_SURNAME")
    private String guestSurname;

    @Column(name = "GUEST_EMAIL", unique = true, nullable = false)
    private String guestEmail;
}
