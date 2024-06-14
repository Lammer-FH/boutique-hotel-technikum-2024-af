package com.fhtechnikum.hotel_backend.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

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

    @ManyToMany(targetEntity = Extra.class, cascade = CascadeType.ALL)
    @JoinTable(name = "ROOM_EXTRA",
            joinColumns = { @JoinColumn(name = "ROOM_ID_FK") },
            inverseJoinColumns = { @JoinColumn(name = "EXTRA_ID_FK") })
    private Set<Extra> roomExtras;
}
