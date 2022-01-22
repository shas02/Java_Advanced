package com.java_advanced.dao;

import com.java_advanced.entity.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ComputerDao extends JpaRepository<Computer, Integer> {

    @Query("SELECT c FROM Computer c WHERE c.brand LIKE :brand")
    Optional<Computer> findByBrand(String brand);
}
