package com.fhtechnikum.hotel_backend.controller;

import com.fhtechnikum.hotel_backend.model.Room;
import com.fhtechnikum.hotel_backend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.*;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {
    @Autowired
    private RoomService service;

    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping(path = "")
    public Map<String, Object> getAllRooms() {
        Iterable<Room> resultFromService = service.getAllRooms();
        Map<String, Object> response = new HashMap<>();
        response.put("rooms", resultFromService);
        return response;
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping("/{roomId}")
    public ResponseEntity<Room> getRoomById(@PathVariable int roomId) {
        Optional<Room> room = service.getRoomById(roomId);
        return room.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}


