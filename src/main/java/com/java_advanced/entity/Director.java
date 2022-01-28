package com.java_advanced.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String name;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDate;

    @OneToMany(targetEntity = Movie.class)
    @JoinColumn(name = "director_id")
    @JsonIgnore
    private List<Movie> movies;
}
