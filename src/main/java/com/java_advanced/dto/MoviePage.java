package com.java_advanced.dto;

import com.java_advanced.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MoviePage {

    private List<Movie> movies;
    private long totalElements;
    private int currentPage;
    private boolean last;
}
