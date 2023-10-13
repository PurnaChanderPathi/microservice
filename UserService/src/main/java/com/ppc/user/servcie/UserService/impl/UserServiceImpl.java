package com.ppc.user.servcie.UserService.impl;

import com.ppc.user.servcie.UserService.entities.Hotel;
import com.ppc.user.servcie.UserService.entities.Rating;
import com.ppc.user.servcie.UserService.entities.User;
import com.ppc.user.servcie.UserService.exceptions.ResoruceNotFoundException;
import com.ppc.user.servcie.UserService.external.service.HotelService;
import com.ppc.user.servcie.UserService.repositories.UserRepository;
import com.ppc.user.servcie.UserService.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HotelService hotelService;

    private Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        // generate Unique UserId
        String ramdomUserId = UUID.randomUUID().toString();
        user.setUserId(ramdomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getById(String userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResoruceNotFoundException("User with given Id was not found on Server :"+userId));
        // fetch rating of above user from RATING-SERVICE
        //http://localhost:8084/ratings/users/d8480f64-6d87-4a0c-b270-735e4e82a59f
        Rating[] forObject = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
        logger.info("{}",forObject);
        List<Rating> ratings = Arrays.stream(forObject).toList();

        List<Rating> ratingList = ratings.stream().map(rating ->
        {
            //api call to hotal service to get the Hotel
            //http://localhost:8083/hotels/7a131024-5b66-4a5c-93f5-701797217443
            //ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
            //Hotel hotel = forEntity.getBody();
            Hotel hotel=hotelService.getHotel(rating.getHotelId());
            //logger.info("Responce Status Code: {}",forEntity.getStatusCode());
            //set the Hotel to rating
            rating.setHotel(hotel);
            //return the rating
            return rating;
        }).collect(Collectors.toList());


        user.setRatings(ratingList);
        return user;
    }
}
