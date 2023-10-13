package com.ppc.user.servcie.UserService.external.service;

import com.ppc.user.servcie.UserService.entities.Hotel;
import com.ppc.user.servcie.UserService.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
@Service
@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    //get
    @GetMapping("/ratings/{ratingId}")
    public Rating getRating(@PathVariable("ratingId") String ratingId);

    //post
    @PostMapping("/ratings")
    public Rating createRating(Rating values);

    //put
    @PutMapping("/ratings/{ratingId}")
    public Rating updateRating(@PathVariable("ratingId") String ratingId, Rating rating );

    //delete
    @DeleteMapping("/ratings/{ratingId}")
    public Rating deleteRating(@PathVariable String ratingId);

}
