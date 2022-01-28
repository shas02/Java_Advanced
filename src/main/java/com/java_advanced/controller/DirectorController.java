package com.java_advanced.controller;

import com.java_advanced.dto.DirectorListDto;
import com.java_advanced.entity.Director;
import com.java_advanced.service.DirectorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/director")
@RequiredArgsConstructor /*створює конструктор для полів позначених final*/
@Slf4j
public class DirectorController {

    private final DirectorService directorService;

    @GetMapping
    public List<DirectorListDto> getDirectors() {
        return directorService.getAllDirectors();
    }

    @GetMapping(value = "/{id}")
    public Director getDirector(@PathVariable int id) {
        return directorService.getDirectorById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Director insertDirector(@RequestBody @Valid Director director) {
        log.info("Handling POST request for object {}", director);
        return directorService.createDirector(director);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Director updateDirector(@PathVariable int id, @RequestBody @Valid Director director) {
        return directorService.updateDirector(id, director);
    }


    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDirector(@PathVariable int id) {
        directorService.deleteDirector(id);
    }
}
