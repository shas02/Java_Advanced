package com.java_advanced.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MovieDto {
    private int movieId;
    private String title;
    private int duration;
    private int directorId;
}
