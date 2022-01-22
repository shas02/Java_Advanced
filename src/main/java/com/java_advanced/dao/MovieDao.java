package com.java_advanced.dao;

import com.java_advanced.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MovieDao extends JpaRepository<Movie, Integer> {

    //todo: query
//    List<Movie> findAllByTitle(String title);
    @Query("SELECT m FROM Movie m WHERE m.title LIKE :title")
    Optional<Movie> findByTitle(String title);
//    @Query("select title from Movie where title like :t")
//    String findByTitle(String t);
}
