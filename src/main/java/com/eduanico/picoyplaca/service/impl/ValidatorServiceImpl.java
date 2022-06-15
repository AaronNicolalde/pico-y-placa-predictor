package com.eduanico.picoyplaca.service.impl;

import com.eduanico.picoyplaca.service.ValidatorService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ValidatorServiceImpl implements ValidatorService {

    /*
    Return true if plateNumber matches pattern @@@-####, if not return false.
     */
    @Override
    public boolean validatePlateNumberFormat(String plateNumber) {
        Pattern pattern = Pattern.compile("([A-Z][A-Z][A-Z])-[0-9][0-9][0-9][0-9]?");

        Matcher matcher = pattern.matcher(plateNumber);

        return matcher.matches();
    }

    /*
    Return true if date matches pattern dd/MM/yyyy, if not return exception and false.
     */
    @Override
    public boolean validateDateFormat(String date) {
        DateTimeFormatter PARSE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate.parse(date, PARSE_FORMATTER);
            return true;
        } catch (DateTimeParseException e) {
            System.out.println("This is not a valid date.");
            return false;
        }
    }

    /*
    Return true if time matches pattern hh:mm, if not return false.
     */
    @Override
    public boolean validateTimeFormat(String time) {
        Pattern pattern = Pattern.compile("([0-1][0-9]|2[0-3]):[0-5][0-9]");

        Matcher matcher = pattern.matcher(time);

        return matcher.matches();
    }
}
