package com.eduanico.picoyplaca.service.impl;

import com.eduanico.picoyplaca.model.Predictor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@RunWith(MockitoJUnitRunner.class)
@DisplayName("Predictor service Tests")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PredictorServiceImplTest {

    @InjectMocks
    private PredictorServiceImpl predictorService;

    @Test
    @DisplayName("Get last digit returns int when successful.")
    void getLastDigit_ReturnsInt_WhenSuccessful() {
        assertThat(predictorService.getLastDigit("GSK-2332")).isEqualTo(2);
    }

    @Test
    @DisplayName("Get day of week returns string when successful.")
    void getDayOfWeek_ReturnsString_WhenSuccessful() {
        assertThat(predictorService.getDayOfWeek("15/03/2022")).isInstanceOf(String.class);
    }

    @Test
    @DisplayName("Get day of week returns null when failed.")
    void getDayOfWeek_ReturnsNull_WhenFailed() {
        assertThat(predictorService.getDayOfWeek("15/2022")).isNull();
    }

    @Test
    @DisplayName("Get validate returns true when successful.")
    void validate_ReturnsTrue_WhenSuccessful() {
        Predictor predictor = mock(Predictor.class);

        when(predictor.getTime()).thenReturn("02:00");

        assertThat(predictorService.validate(predictor)).isTrue();
    }

    @Test
    @DisplayName("Get validate returns false when failed.")
    void validate_ReturnsFalse_WhenFailed() {
        Predictor predictor = mock(Predictor.class);

        when(predictor.getTime()).thenReturn("08:00");
        when(predictor.getDate()).thenReturn("16/07/2022");
        when(predictor.getPlateNumber()).thenReturn("GSK-2233");

        assertThat(predictorService.validate(predictor)).isTrue();
    }


    @Test
    @DisplayName("Get validate morning time returns true when successful.")
    void validateMorningTime_ReturnsTrue_WhenSuccessful() {
        assertThat(predictorService.validateMorningTime("08:00")).isTrue();
    }

    @Test
    @DisplayName("Get validate morning time returns false when failed.")
    void validateMorningTime_ReturnsFalse_WhenFailed() {
        assertThat(predictorService.validateMorningTime("06:00")).isFalse();
    }



    @Test
    @DisplayName("Get validate afternoon time returns true when successful.")
    void validateAfternoonTime_ReturnsTrue_WhenSuccessful() {
        assertThat(predictorService.validateAfternoonTime("17:00")).isTrue();

    }

    @Test
    @DisplayName("Get validate afternoon time returns false when failed.")
    void validateAfternoonTime_ReturnsFalse_WhenFailed() {
        assertThat(predictorService.validateAfternoonTime("14:00")).isFalse();

    }

    @Test
    @DisplayName("Get validate Date and Digit returns true when digit is 1 or 2 and day is Lunes.")
    void validateDateAndDigit_ReturnsTrue_WhenDayLunes() {
        assertThat(predictorService.validateDateAndDigit("Lunes",1)).isTrue();
    }

    @Test
    @DisplayName("Get validate Date and Digit returns true when digit is 3 or 4 and day is Martes.")
    void validateDateAndDigit_ReturnsTrue_WhenDayMartes() {
        assertThat(predictorService.validateDateAndDigit("Martes",3)).isTrue();
    }

    @Test
    @DisplayName("Get validate Date and Digit returns true when digit is 5 or 6 and day is Miércoles.")
    void validateDateAndDigit_ReturnsTrue_WhenDayMiércoles() {
        assertThat(predictorService.validateDateAndDigit("Miércoles",5)).isTrue();
    }

    @Test
    @DisplayName("Get validate Date and Digit returns true when digit is 7 or 8 and day is Jueves.")
    void validateDateAndDigit_ReturnsTrue_WhenDayJueves() {
        assertThat(predictorService.validateDateAndDigit("Jueves",8)).isTrue();
    }

    @Test
    @DisplayName("Get validate Date and Digit returns true when digit is 9 or 0 and day is Viernes.")
    void validateDateAndDigit_ReturnsTrue_WhenDayViernes() {
        assertThat(predictorService.validateDateAndDigit("Viernes",0)).isTrue();
    }


}