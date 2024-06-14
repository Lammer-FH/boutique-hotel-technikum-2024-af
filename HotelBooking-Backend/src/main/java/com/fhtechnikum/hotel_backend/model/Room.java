package com.fhtechnikum.hotel_backend.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "ROOM")
@Table(name = "ROOM")
@Getter
@Setter
@NoArgsConstructor
public class Room {
    @Id
    @Column(name = "ROOM_ID")
    private int roomId;
    @Column(name = "ROOM_TITLE")
    private String roomTitle;
    @Column(name = "ROOM_DESCRIPTION")
    private String roomDescription;
}
