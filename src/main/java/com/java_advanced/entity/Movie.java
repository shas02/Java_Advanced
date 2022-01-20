package com.java_advanced.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;


@RequiredArgsConstructor
@Data
@Entity
//@Table(name = "MOVIE_TABLE")

public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) /*генерує нові Id*/
    private int id;
    @Column(nullable = false, length = 100) /*налаштовує параметри стовпця, які будуть передані в базу даних*/
    @NotBlank
//    @JsonProperty("title-of-movie") /*переіменовує пропертю*/
    private String title;
    @Column(nullable = false, length = 100)
    @Positive
    private int duration;

}
