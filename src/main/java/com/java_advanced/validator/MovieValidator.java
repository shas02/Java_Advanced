package com.java_advanced.validator;

import com.java_advanced.entity.Movie;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class MovieValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Movie.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Movie movie = (Movie) target;
//        if (StringUtils.isNotBlank(movie.getTitle())) {
//            errors.rejectValue("title", "movie.title.capital-letter", "Movie title should not be blank!");
//        }
        if (StringUtils.isNotBlank(movie.getTitle()) && !CharUtils.isAsciiAlphaUpper(movie.getTitle().charAt(0))) {
            errors.rejectValue("title", "movie.title.capital-letter", "Movie title should start with capital letter!");
        }
    }
}
