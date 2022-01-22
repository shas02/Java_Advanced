package com.java_advanced.service;


import com.java_advanced.dao.ComputerDao;
import com.java_advanced.dto.ComputerPage;
import com.java_advanced.entity.Computer;
import com.java_advanced.exceptions.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.CharUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ComputerServiceImp implements ComputerService {

    @Autowired
    private final ComputerDao computerDao;

    @Override
    public ComputerPage getAllComputers(int page, int size) {
        final Page<Computer> computers = computerDao.findAll(PageRequest.of(page, size));
        final ComputerPage computerPage = new ComputerPage();
        computerPage.setComputers(computers.getContent());
        computerPage.setCurrentPage(computers.getNumber());
        computerPage.setLast(computers.isLast());
        computerPage.setTotalElements(computers.getTotalElements());
        return computerPage;
    }

    @Override
    public Computer getComputerById(int id) {
        return computerDao.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "No computer with id: " + id));
    }

    @Override
    public Optional<Computer> getComputerByBrand(String brand) {
        final Optional<Computer> computer = computerDao.findByBrand(brand);
        return Optional.ofNullable(computer.orElseThrow(() -> new ItemNotFoundException("Computer", "brand", brand)));
    }

    @Override
    public Computer createComputer(Computer computer) {
        if (!CharUtils.isAsciiAlphaUpper(computer.getBrand().charAt(0))) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Brand should start with capital letter");
        }
        return computerDao.saveAndFlush(computer);
    }

    @Override
    public Computer updateComputer(int id, Computer computer) {
        computer.setId(id);
        if (!computerDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No computer found");
        }
        return computerDao.saveAndFlush(computer);
    }

    @Override
    public void deleteComputer(int id) {
        if (!computerDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No computer found");
        }
        computerDao.deleteById(id);
    }
}
