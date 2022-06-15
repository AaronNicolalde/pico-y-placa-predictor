package com.eduanico.picoyplaca.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


@Getter
@Setter
@NoArgsConstructor
public class Predictor {

    /**
     * plateNumber must be in "G**-####" format
     */
    @NotEmpty(message = "Plate number can not be empty.")
    String plateNumber;

    /**
     * date must be in "dd/MM/yyyy" format
     */
    @NotEmpty(message = "Date can not be empty.")
    @Pattern(regexp="(^(0?[1-9]|[12][0-9]|3[01])[/\\-](0?[1-9]|1[012])[/\\-]\\d{4}$)", message = "Date should follow the next pattern dd/MM/yyyy")
    String date;

    /**
     * time must be in "hh:mm" format
     */
    @NotEmpty(message = "Time can not be empty.")
    @Pattern(regexp="(^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$)", message = "Time should follow the next pattern hh:mm")
    String time;


    public Predictor(String plateNumber, String date, String time) {
        this.plateNumber = plateNumber;
        this.date = date;
        this.time = time;
    }
}
