package org.example.weather.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class CityValidatorTest {

    private final CityValidator cityValidator = new CityValidator();

    @Test
    void testIsValidCityName() {
        assertTrue(cityValidator.isValidCityName("London"));
        assertFalse(cityValidator.isValidCityName("InvalidCity123"));
    }
}
