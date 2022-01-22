package com.java_advanced.dto;

import com.java_advanced.entity.Computer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ComputerPage {
    private List<Computer> computers;
    private long totalElements;
    private int currentPage;
    private boolean last;
}
