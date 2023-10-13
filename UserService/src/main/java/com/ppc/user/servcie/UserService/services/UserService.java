package com.ppc.user.servcie.UserService.services;

import com.ppc.user.servcie.UserService.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    //User Operation

    //create
    User saveUser( User user);

    // get all users

    List<User> getAllUsers();

    //get Single User

    User getById(String userId);

}
