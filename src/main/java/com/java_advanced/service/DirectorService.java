package com.java_advanced.service;

import com.java_advanced.dto.DirectorListDto;
import com.java_advanced.dto.MoviePage;
import com.java_advanced.entity.Director;
import com.java_advanced.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface DirectorService {

    List<DirectorListDto> getAllDirectors();

    Director getDirectorById(int id);

    Director createDirector(Director director);

    Director updateDirector(int id, Director director);

    void deleteDirector(int id);
}
