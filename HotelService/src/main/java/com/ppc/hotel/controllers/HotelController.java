package com.ppc.hotel.controllers;

import com.ppc.hotel.entities.Hotel;
import com.ppc.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
    }
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotel()
    {
        return ResponseEntity.ok(hotelService.getAllUsers());
    }
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getUserById(@PathVariable String hotelId)
    {
        return ResponseEntity.ok(hotelService.getByUserId(hotelId));
    }
}
