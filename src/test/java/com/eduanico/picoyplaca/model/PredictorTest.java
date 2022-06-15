package com.eduanico.picoyplaca.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@RunWith(MockitoJUnitRunner.class)
@DisplayName("Predictor Tests")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PredictorTest {

    @Test
    void predicatorTest(){
        Predictor predictor = new Predictor("GSK-1231","16/10/2022", "08:30");

        Predictor predictor1 = new Predictor();

        predictor1.setTime(predictor.getTime());
        predictor1.setDate(predictor.getDate());
        predictor1.setPlateNumber(predictor.getPlateNumber());
    }

}