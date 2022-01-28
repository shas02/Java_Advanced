package com.java_advanced.service;

import com.java_advanced.dto.MovieCreateDto;
import com.java_advanced.dto.MoviePage;
import com.java_advanced.entity.Movie;

import java.util.Optional;

public interface MovieService {

    Movie getMovieById(int id);

    Optional<Movie> getMovieByTitle(String title);

    MoviePage getAllMovies(int page, int size);

    MovieCreateDto createMovie(MovieCreateDto movie);

    Movie updateMovie(int id, Movie movie);

    void deleteMovie(int id);



}
