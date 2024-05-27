package com.fhtechnikum.hotel_backend.service;
import com.fhtechnikum.hotel_backend.model.Room;
import com.fhtechnikum.hotel_backend.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public Iterable<Room> getAllRooms(){
        return roomRepository.findAll();
    }

}
