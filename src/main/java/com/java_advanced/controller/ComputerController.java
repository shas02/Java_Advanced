package com.java_advanced.controller;

import com.java_advanced.dto.ComputerPage;
import com.java_advanced.entity.Computer;
import com.java_advanced.service.ComputerService;
import com.java_advanced.validator.ComputerValidator;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/computer")
public class ComputerController {

    private static Logger LOG = LoggerFactory.getLogger(ComputerController.class);

    @Autowired
    private final ComputerService computerService;

    @Autowired
    private ComputerValidator computerValidator;

    @GetMapping
    public ComputerPage getComputers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size) {
        return computerService.getAllComputers(page, size);
    }

    @GetMapping(value ="/{id}")
    public Computer getComputer(@PathVariable int id) {
        return computerService.getComputerById(id);
    }

    @GetMapping(value ="/title/{brand}")
    public Optional<Computer> getComputerByTitle(@PathVariable String brand) {
        return computerService.getComputerByBrand(brand);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Computer insertMovie(@RequestBody @Valid Computer computer) {
        LOG.info("Handling POST request for object {}", computer);
        return computerService.createComputer(computer);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Computer updateComputer(@PathVariable int id, @RequestBody @Valid Computer computer) {
        return computerService.updateComputer(id, computer);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComputer(@PathVariable int id) {
        computerService.deleteComputer(id);
    }
}
