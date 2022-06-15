package com.eduanico.picoyplaca.service;

import com.eduanico.picoyplaca.model.Predictor;

public interface PredictorService {

    int getLastDigit(String plateNumber);

    String getDayOfWeek(String date);



    boolean validate(Predictor predictor);

}
