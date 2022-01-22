package com.java_advanced.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 50)
    @NotBlank
    private String brand;
    @Column(nullable = false, length = 50)
    @NotBlank
    private String model;
    private int ram;
    private double CPU_frequency;
    private double monitor_inches;
}
