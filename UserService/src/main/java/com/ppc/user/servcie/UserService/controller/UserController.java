package com.ppc.user.servcie.UserService.controller;

import com.ppc.user.servcie.UserService.entities.User;
import com.ppc.user.servcie.UserService.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class  UserController {

    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        User userdetails = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userdetails);
    }
    int retrycount=1;
    @GetMapping("/{userid}")
    //@Retry(name = "ratingHotelService",fallbackMethod = "ratingHotelFallBack")
    //@CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallBack")
    @RateLimiter(name = "userRateLimiter",fallbackMethod = "ratingHotelFallBack")
    public ResponseEntity<User> getUserByid(@PathVariable String userid)
    {
        System.out.println("retrycount: "+retrycount);
       retrycount++;
        User user = userService.getById(userid);
        return ResponseEntity.ok(user);
    }
    //creating fall back method for circuitbreaker

    public ResponseEntity<User> ratingHotelFallBack(String userid,Exception ex)
    {

        User user = User.builder()
                .email("dummy@gmail.com")
                .name("Dummy")
                .about("This user is created dummy because some service is down")
                .userId("3343")
                .build();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers()
    {
        List<User> userDetails = userService.getAllUsers();
        return ResponseEntity.ok(userDetails);
    }
}
