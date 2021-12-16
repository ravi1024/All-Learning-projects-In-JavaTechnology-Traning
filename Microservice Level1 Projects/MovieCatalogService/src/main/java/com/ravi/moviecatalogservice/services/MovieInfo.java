package com.ravi.moviecatalogservice.services;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ravi.moviecatalogservice.model.Movie;
import com.ravi.moviecatalogservice.model.Rating;
import com.ravi.moviecatalogservice.model.UserRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfo {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackMovie"/*,
            commandProperties = {
                @HystrixProperty(name = "execution.isolation.thread.timeoutInMillisecond" ,value = "2000" ),
                @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold" ,value = "5"),
                @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage" ,value = "50"),
                @HystrixProperty(name = "circuitBreaker.sleepWindowInMillisecond" ,value = "5000"),
            }*/)

    public Movie getMovie(Rating rating) {
        return restTemplate.getForObject("http://Movie-Info-Service/movies/" + rating.getMovieId(), Movie.class);
    }

    public Movie getFallbackMovie(Rating rating) {
        return new Movie("", "" ,"Movie not found" , "");
    }

}
