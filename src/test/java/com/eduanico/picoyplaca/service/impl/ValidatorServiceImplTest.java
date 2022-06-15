package com.eduanico.picoyplaca.service.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.regex.Matcher;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@RunWith(MockitoJUnitRunner.class)
@DisplayName("Validator service Tests")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ValidatorServiceImplTest {

    @InjectMocks
    private ValidatorServiceImpl validatorService;

    @Test
    @DisplayName("Validates plate number format returns true when successful.")
    void validatePlateNumberFormat_ReturnsTrue_WhenSuccessful() {
        Matcher platePattern = mock(Matcher.class);

        when(platePattern.matches()).thenReturn(true);

        assertThat(validatorService.validatePlateNumberFormat("GSK-1234")).isTrue();
    }

    @Test
    @DisplayName("Validates plate number format return false when failed.")
    void validatePlateNumberFormat_ReturnsFalse_WhenFailed() {
        Matcher platePattern = mock(Matcher.class);

        when(platePattern.matches()).thenReturn(false);

        assertThat(validatorService.validatePlateNumberFormat("GSK-1")).isFalse();
    }

    @Test
    @DisplayName("Validates date format return true when successful.")
    void validateDateFormat_ReturnsTrue_WhenSuccessful() {
        Matcher datePattern = mock(Matcher.class);

        when(datePattern.matches()).thenReturn(true);

        assertThat(validatorService.validateDateFormat("12/01/2022")).isTrue();
    }

    @Test
    @DisplayName("Validates date format return false when failed.")
    void validateDateFormat_ReturnsFalse_WhenFailed() {
        Matcher datePattern = mock(Matcher.class);

        when(datePattern.matches()).thenReturn(false);

        assertThat(validatorService.validateDateFormat("12/2022")).isFalse();
    }


    @Test
    @DisplayName("Validates time format return true when successful.")
    void validateTimeFormat_ReturnsTrue_WhenSuccessful() {
        Matcher timePattern = mock(Matcher.class);

        when(timePattern.matches()).thenReturn(true);

        assertThat(validatorService.validateTimeFormat("08:00")).isTrue();
    }

    @Test
    @DisplayName("Validates time format return false when failed.")
    void validateTimeFormat_ReturnsFalse_WhenFailed() {
        Matcher timePattern = mock(Matcher.class);

        when(timePattern.matches()).thenReturn(false);

        assertThat(validatorService.validateTimeFormat("08:80")).isFalse();
    }
}