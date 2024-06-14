package com.fhtechnikum.hotel_backend.controller;

import com.fhtechnikum.hotel_backend.model.Room;
import com.fhtechnikum.hotel_backend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {
    @Autowired
    private RoomService service;

    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping(path = "")
    public Map<String, Object> getAllRooms(@RequestParam Map<String, String> action) {
        Iterable<Room> resultFromService = null;
        resultFromService = service.getAllRooms();
        Map<String, Object> response = new HashMap<>();
        response.put("rooms", resultFromService);
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Integer id) {
        Optional<Room> room = service.getRoomById(id);
        if (room.isPresent()) {
            return ResponseEntity.ok(room.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


/*

package com.someShop.Controller;
import com.someShop.Model.ProductType;
import com.someShop.Service.ProductDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ProductDataAdministration {
    @Autowired
    private ProductDataService service;

    @GetMapping(path="")
    public Iterable<ProductType> ascertainApiParameter(@RequestParam Map<String, String> action){
        Iterable<ProductType> resultFromService = null;
        switch(action.get("action")){
            case "listTypes":
                resultFromService = service.getAllProductTypes();
                break;
            case "listProductsByTypeId":
                resultFromService = service.getProductsByProductType(Integer.parseInt(action.get("typeId")));
                break;
        }
        return resultFromService;
    }
}

*/
