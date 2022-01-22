package com.java_advanced.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorResponse {

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:SS")
    private LocalDateTime time;
    private int status;
    private String message;

}