package com.ppc.user.servcie.UserService.repositories;

import com.ppc.user.servcie.UserService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String >
{
    //if you want to implement any custom methods or query
}
