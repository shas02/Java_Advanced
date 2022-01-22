package com.java_advanced.service;

import com.java_advanced.dto.MoviePage;
import com.java_advanced.entity.Movie;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    Movie getMovieById(int id);

    Optional<Movie> getMovieByTitle(String title);

    MoviePage getAllMovies(int page, int size);

    Movie createMovie(Movie movie);

    Movie updateMovie(int id, Movie movie);

    void deleteMovie(int id);



}
