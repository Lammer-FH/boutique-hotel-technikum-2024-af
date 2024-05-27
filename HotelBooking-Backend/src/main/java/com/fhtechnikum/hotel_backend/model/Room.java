package com.fhtechnikum.hotel_backend.model;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//import javax.persistence.*;

@JsonPropertyOrder({"id", "title", "description"})
@Entity(name = "ROOM")
@Table(name = "ROOM")
public class Room {
    @Id
    @Column 
    private int ROOM_ID;
    @Column
    private String ROOM_TITLE;
    @Column
    private String ROOM_DESCRIPTION;

    public Room() {}

    public int getId(){return ROOM_ID;}
    public String getTitle(){return ROOM_TITLE;}
    public String getDescription(){return ROOM_DESCRIPTION;}

}
