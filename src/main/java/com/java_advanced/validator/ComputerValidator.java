package com.java_advanced.validator;

import com.java_advanced.entity.Computer;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class ComputerValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return Computer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Computer computer = (Computer) target;
        if (StringUtils.isNotBlank(computer.getBrand()) || StringUtils.isNotBlank(computer.getModel()) || !CharUtils.isAsciiAlphaUpper(computer.getBrand().charAt(0))) {
            errors.rejectValue("brand", "computer.brand.capital-letter", "Computer brand should start with capital letter!");
        }
    }
}
