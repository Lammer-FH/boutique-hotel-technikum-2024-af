package com.fhtechnikum.hotel_backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {

    @GetMapping
    public Map<String, String> getRooms() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello World");
        return response;
    }
}

