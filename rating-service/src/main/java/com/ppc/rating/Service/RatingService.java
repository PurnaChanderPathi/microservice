package com.ppc.rating.Service;

import com.ppc.rating.entities.Rating;
import com.ppc.rating.repositories.RatingRepository;

import java.util.List;

public interface RatingService {
    //Create Rating
     Rating create(Rating rating);

     //getallRating
    List<Rating> getAllRating();

    //getbyUserId
    List<Rating> getById(String userId);

    //get rating by hotel id
    List<Rating> getByHotelId(String hotelId);

}
