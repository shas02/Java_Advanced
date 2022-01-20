package com.java_advanced.controller;

import com.java_advanced.entity.Movie;
import com.java_advanced.service.MovieService;
import com.java_advanced.validator.MovieValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/movie")
public class MovieController {

    @Autowired
    private final MovieService movieService;

    @Autowired
    private MovieValidator movieValidator;

    //    @RequestMapping(value = "/movie", method = RequestMethod.GET)
    @GetMapping
    public List<Movie> getMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping(value = "/{id}")
    public Movie getMovie(@PathVariable int id) {
        return movieService.getMovieById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Movie insertMovie(@RequestBody @Valid Movie movie) {
        return movieService.createMovie(movie);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Movie updateMovie(@PathVariable int id, @RequestBody @Valid Movie movie) {
        return movieService.updateMovie(id, movie);
    }


    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovie(@PathVariable int id) {
        movieService.deleteMovie(id);
    }

//    @InitBinder
//    public void initBinder(WebDataBinder dataBinder) {
//        dataBinder.addValidators(movieValidator);
//    }
}
