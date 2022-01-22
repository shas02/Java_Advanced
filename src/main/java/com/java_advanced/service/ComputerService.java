package com.java_advanced.service;

import com.java_advanced.dto.ComputerPage;
import com.java_advanced.entity.Computer;

import java.util.List;
import java.util.Optional;

public interface ComputerService {

    ComputerPage getAllComputers(int oage, int size);

    Computer getComputerById(int id);

    Optional<Computer> getComputerByBrand(String brand);

    Computer createComputer(Computer computer);

    Computer updateComputer(int id, Computer computer);

    void deleteComputer(int id);
}
