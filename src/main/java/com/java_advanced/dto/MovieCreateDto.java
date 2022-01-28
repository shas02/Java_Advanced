package com.java_advanced.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Data
public class MovieCreateDto {

    private int id;
    private String title;
    private int duration;
    private int directorId;
}
