package com.java_advanced.service;

import com.java_advanced.dao.DirectorDao;
import com.java_advanced.dto.DirectorListDto;
import com.java_advanced.entity.Director;
import com.java_advanced.entity.Movie;
import com.java_advanced.exceptions.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DirectorServiceImpl implements DirectorService {

    @Autowired
    private final DirectorDao directorDao;

    @Override
    public List<DirectorListDto> getAllDirectors() {
        List<Director> directorDaoAll = directorDao.findAll();
        List<DirectorListDto> collect = directorDaoAll.stream()
                .map(director -> {
                    DirectorListDto directorListDto = new DirectorListDto();
                    directorListDto.setDirectorId(director.getId());
                    directorListDto.setName(director.getName());

                    final List<Integer> ids = director.getMovies().stream()
                            .map(Movie::getId)
                            .collect(Collectors.toList());
                    directorListDto.setMovies(ids);
                    return directorListDto;
                }).collect(Collectors.toList());
        return collect;
    }

    @Override
    public Director getDirectorById(int id) {
        return directorDao.findById(id).orElseThrow(() -> new ItemNotFoundException("director", "id", String.valueOf(id)));
    }

    @Override
    public Director createDirector(Director director) {
        return directorDao.save(director);
    }

    @Override
    public Director updateDirector(int id, Director director) {
        director.setId(id);
        if (!directorDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No director found");
        }
        return directorDao.saveAndFlush(director);
    }

    @Override
    public void deleteDirector(int id) {
        directorDao.deleteById(id);
    }
}
