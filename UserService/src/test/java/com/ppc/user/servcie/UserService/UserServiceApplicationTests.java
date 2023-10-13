package com.ppc.user.servcie.UserService;

import com.ppc.user.servcie.UserService.entities.Rating;
import com.ppc.user.servcie.UserService.external.service.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	private RatingService ratingService;

	//@Test
//	void createRating()
//	{
//		Rating savedRating= Rating.builder().rating(4).userId("").hotelId("").feedback("this is created by FeignClient  ").build();
//		ratingService.createRating(savedRating);
//	}

}
