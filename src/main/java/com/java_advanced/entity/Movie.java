package com.java_advanced.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Movie {

    private int id;
    private String title;
    private int duration;
}
