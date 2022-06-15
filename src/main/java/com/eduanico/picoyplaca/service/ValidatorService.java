package com.eduanico.picoyplaca.service;

public interface ValidatorService {

    boolean validatePlateNumberFormat(String plateNumber);
    boolean validateDateFormat(String date);
    boolean validateTimeFormat(String time);

}
