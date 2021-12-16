package com.ravi.ratingdataservice.controller;


import com.ravi.ratingdataservice.model.Rating;
import com.ravi.ratingdataservice.model.UserRatings;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingDataServiceController {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 9);
    }

    @RequestMapping("/user/{userId}")
    public UserRatings getUserRatings(@PathVariable("userId") String userId) {
        List<Rating> ratingList = Arrays.asList(
                new Rating("100",9),
                new Rating("200",7)
        );

        UserRatings userRatings = new UserRatings();
        userRatings.setRatingList(ratingList);
        return userRatings;
    }
}
