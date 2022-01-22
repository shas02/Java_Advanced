package com.java_advanced.service;

import com.java_advanced.dao.MovieDao;
import com.java_advanced.dto.MoviePage;
import com.java_advanced.entity.Movie;
import com.java_advanced.exceptions.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.CharUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    @Autowired
    private final MovieDao movieDao;

    @Override
    public Movie getMovieById(int id) {
        return movieDao.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "No movie with id: " + id));
    }

    @Override
    public Optional<Movie> getMovieByTitle(String title) {
        final Optional<Movie> movie = movieDao.findByTitle(title);
        return Optional.ofNullable(movie.orElseThrow(() -> new ItemNotFoundException("Movie", "title", title)));
    }

    @Override
    public MoviePage getAllMovies(int page, int size) {
        final Page<Movie> movies = movieDao.findAll(PageRequest.of(page, size));
        final MoviePage moviePage = new MoviePage();
        moviePage.setMovies(movies.getContent());
        moviePage.setCurrentPage(movies.getNumber());
        moviePage.setLast(movies.isLast());
        moviePage.setTotalElements(movies.getTotalElements());
        return moviePage;
    }

    @Override
    public Movie createMovie(Movie movie) {
        if (!CharUtils.isAsciiAlphaUpper(movie.getTitle().charAt(0))) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Title should start with capital letter");
        }
        return movieDao.saveAndFlush(movie);
    }

    @Override
    public Movie updateMovie(int id, Movie movie) {
        movie.setId(id);
        if (!movieDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No movie found");
        }
        return movieDao.saveAndFlush(movie);
    }

    @Override
    public void deleteMovie(int id) {
        if (!movieDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No movie found");
        }
        movieDao.deleteById(id);
    }
}
