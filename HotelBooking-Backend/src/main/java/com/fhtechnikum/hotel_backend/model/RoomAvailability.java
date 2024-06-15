package com.fhtechnikum.hotel_backend.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RoomAvailability {
    private final boolean roomIsAvailable;
    private final LocalDateTime nextTimeAvailable;

    public RoomAvailability(boolean roomIsAvailable, LocalDateTime nextTimeAvailable) {
        this.roomIsAvailable = roomIsAvailable;
        this.nextTimeAvailable = nextTimeAvailable;
    }
}
