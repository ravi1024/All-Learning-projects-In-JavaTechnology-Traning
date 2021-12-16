package com.ravi.movieinfoservice.controller;


import com.ravi.movieinfoservice.model.Movie;
import com.ravi.movieinfoservice.model.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieServiceController {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    /*@RequestMapping("/{movieId}")
    public Movie getMovie(@PathVariable("movieId") String movieId) {
        return new Movie(movieId,"Test name");
    }*/


    @RequestMapping("/{movieId}")
    public Movie getMovieDetails(@PathVariable("movieId") String movieId) {

        MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/"+ movieId + "?api_key=" + apiKey, MovieSummary.class );
        return new Movie(movieSummary.getId(), movieSummary.getLanguage(), movieSummary.getTitle(), movieSummary.getOverview());
    }

}
