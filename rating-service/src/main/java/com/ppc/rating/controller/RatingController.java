package com.ppc.rating.controller;

import com.ppc.rating.Service.RatingService;
import com.ppc.rating.entities.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    //create
    @PostMapping
    public ResponseEntity<Rating> CreateUser(@RequestBody Rating rating)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }
    @GetMapping
    public ResponseEntity<List<Rating>> getRating()
    {
        return ResponseEntity.ok(ratingService.getAllRating());
    }
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId )
    {
        return ResponseEntity.ok(ratingService.getById(userId));
    }
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId)
    {
        return ResponseEntity.ok(ratingService.getByHotelId(hotelId));
    }

}
