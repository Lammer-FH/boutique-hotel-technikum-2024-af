package com.fhtechnikum.hotel_backend.controller;

import com.fhtechnikum.hotel_backend.model.Room;
import com.fhtechnikum.hotel_backend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {
/*
    @GetMapping
    public Map<String, String> getRooms() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello World");
        return response;
    }
*/
    @Autowired
    private RoomService service;

    @GetMapping(path="")
    public Iterable<Room> ascertainApiParameter(@RequestParam Map<String, String> action){
        Iterable<Room> resultFromService = null;
        resultFromService = service.getAllRooms();
        return resultFromService;
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
