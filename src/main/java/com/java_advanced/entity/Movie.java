package com.java_advanced.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;


@RequiredArgsConstructor
@Data
@Entity
//@Table(name = "MOVIE_TABLE")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) /*генерує нові Id*/
    private int id;
    @Column(nullable = false, length = 100) /*налаштовує параметри стовпця, які будуть передані в базу даних*/
    private String title;
    @Column(nullable = false, length = 100)
    private int duration;

}
