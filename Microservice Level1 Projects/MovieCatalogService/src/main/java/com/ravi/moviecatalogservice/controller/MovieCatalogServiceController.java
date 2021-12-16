package com.ravi.moviecatalogservice.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ravi.moviecatalogservice.model.CatalogItem;
import com.ravi.moviecatalogservice.model.Movie;
import com.ravi.moviecatalogservice.model.Rating;
import com.ravi.moviecatalogservice.model.UserRatings;
import com.ravi.moviecatalogservice.services.MovieInfo;
import com.ravi.moviecatalogservice.services.RatingDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogServiceController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private MovieInfo movieInfo;

    @Autowired
    private RatingDataInfo ratingDataInfo;

    @RequestMapping("/{userId}")
//    @HystrixCommand(fallbackMethod = "getFallbackCatalog")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        //Following is not the right way to get instance of RestTemplate, instead we should be using Singleton instance of RestTemplate via
        // @Bean and @Autowired
        /*
        RestTemplate restTemplate= new RestTemplate();
        */


        //get all rated movie IDs
        /*List<Rating> ratingList = Arrays.asList(
                new Rating("12345",9),
                new Rating("56789",7)
        );
*/

        UserRatings userRatings = ratingDataInfo.getUserRatings(userId);

        //For each movie ID, call movie info service and get details
        return userRatings.getRatingList().stream().map(rating -> {

            // Synchronous way of REST calling to microservices
            Movie movie = movieInfo.getMovie(rating);


            // Async way of REST calling to microservice, this is alternate for RestTemplate(Soon to  be Deprecated).
            /* Movie movie =  webClientBuilder
                    .build()
                    .get()
                    .uri("http://localhost:8082/movies/" + rating.getMovieId())
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();*/

            //put them all together
            return new CatalogItem(movie.getName(),movie.getLanguage(),movie.getDescription(),rating.getRating());
        }).collect(Collectors.toList());

//        return Collections.singletonList(new CatalogItem("Demon Slayer","Test",9));
    }


    //Bulkhead Pattern (another fall tolerance mechanism ) : we can implement this concept pattern with the help of hystrix
/*
    @HystrixCommand(
            fallbackMethod = "getFallbackCatalog",
            threadPoolKey = "movieInfoPool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "20"),
                    @HystrixProperty(name = "maxQueueSize", value = "10")
            }
    )
    public CatalogItem getCatalogItem(Rating rating) {
        Movie movie = restTemplate.getForObject("http://Movie-Info-Service/movies/" + rating.getMovieId(), Movie.class);
        return new CatalogItem(movie.getName(),movie.getLanguage(),movie.getDescription(),rating.getRating());
    }*/



   /* public List<CatalogItem> getFallbackCatalog(@PathVariable("userId") String userId) {

        return Collections.singletonList(new CatalogItem("NoMovie", "", "", 0));

    }*/
}
