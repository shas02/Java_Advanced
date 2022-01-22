package com.java_advanced.controller;

import com.java_advanced.dto.MoviePage;
import com.java_advanced.entity.Movie;
import com.java_advanced.service.MovieService;
import com.java_advanced.validator.MovieValidator;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/movie")
public class MovieController {


    private static Logger LOG = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private final MovieService movieService;

    @Autowired
    private MovieValidator movieValidator;

    //    @RequestMapping(value = "/movie", method = RequestMethod.GET)
    @GetMapping
    public MoviePage getMovies(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size) {
        return movieService.getAllMovies(page, size);
    }

    @GetMapping(value = "/{id}")
    public Movie getMovie(@PathVariable int id) {
        return movieService.getMovieById(id);
    }

    @GetMapping(value = "/title/{title}")
    public Optional<Movie> getMovieByTitle(@PathVariable String title) {
        return movieService.getMovieByTitle(title);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Movie insertMovie(@RequestBody @Valid Movie movie) {
        LOG.info("Handling POST request for object {}", movie);
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
