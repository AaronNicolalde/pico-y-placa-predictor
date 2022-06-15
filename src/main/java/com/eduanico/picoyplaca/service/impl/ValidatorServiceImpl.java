package com.eduanico.picoyplaca.service.impl;

import com.eduanico.picoyplaca.service.ValidatorService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Service
public class ValidatorServiceImpl implements ValidatorService {


    @Override
    public boolean validatePlateNumberFormat(String plateNumber) {
        return false;
    }

    @Override
    public boolean validateDateFormat(String date) {
        DateTimeFormatter PARSE_FORMATTER = DateTimeFormatter.ofPattern("MM/dd/uuuu");

        try {
            LocalDate.parse(date, PARSE_FORMATTER);
            System.out.println(date + " is a valid Date");
            return true;
        } catch (DateTimeParseException e) {
            System.out.println(e + " is a not valid Date");
            return false;
        }

    }

    @Override
    public boolean validateTimeFormat(String time) {
        return false;
    }
}
