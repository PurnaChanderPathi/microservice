package com.ppc.rating.Service.impl;

import com.ppc.rating.Service.RatingService;
import com.ppc.rating.entities.Rating;
import com.ppc.rating.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepository ratingRepository;
    @Override
    public Rating create(Rating rating) {
        String RatingId = UUID.randomUUID().toString();
        rating.setRatingId(RatingId);
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getById(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
