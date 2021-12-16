package com.ravi.moviecatalogservice.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ravi.moviecatalogservice.model.Rating;
import com.ravi.moviecatalogservice.model.UserRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RatingDataInfo {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackUserRatings")
    public UserRatings getUserRatings(String userId) {
        return restTemplate.getForObject("http://Rating-Data-Service/ratingsdata/user/" + userId, UserRatings.class);
    }

    public UserRatings getFallbackUserRatings(String userId) {
        List<Rating> ratingList = new ArrayList<>();
        ratingList.add(new Rating("0",0));

        UserRatings userRatings=new UserRatings();
        userRatings.setRatingList(ratingList);
        return userRatings;
    }
}
