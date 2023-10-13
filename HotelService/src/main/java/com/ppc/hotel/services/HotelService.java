package com.ppc.hotel.services;

import com.ppc.hotel.entities.Hotel;

import java.util.List;

public interface HotelService {

    //create
    Hotel create(Hotel hotel);

    //getAllUsers
    List<Hotel> getAllUsers();

    // getb single User
    Hotel getByUserId(String id);
}
