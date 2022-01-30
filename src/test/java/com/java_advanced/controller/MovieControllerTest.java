package com.java_advanced.controller;

import com.java_advanced.entity.Director;
import com.java_advanced.entity.Movie;
import com.java_advanced.service.MovieService;
import com.java_advanced.validator.MovieValidator;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(MovieController.class)
@ExtendWith(SpringExtension.class)
public class MovieControllerTest {

    @MockBean
    private MovieService movieService;
    @MockBean
    private MovieValidator movieValidator;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void givenTitleWhenGettingMovieThenReturnMovie() throws Exception {
        Mockito.when(movieService.getMovieByTitle(ArgumentMatchers.anyString()))
                .thenReturn(Optional.of(new Movie(1, "Avengers", 150, new Director())));

        mockMvc.perform(MockMvcRequestBuilders.get("/movie/title/Avengers"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.id", CoreMatchers.is(1)))
                .andExpect(jsonPath("$.title", CoreMatchers.is("Avengers")));
    }
}

