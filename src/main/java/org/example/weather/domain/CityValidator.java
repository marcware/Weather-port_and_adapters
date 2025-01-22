package org.example.weather.domain;

import org.springframework.stereotype.Component;

@Component
public class CityValidator {

    private static final String CITY_NAME_PATTERN = "^[a-zA-Z\\s]+$";

    public boolean isValidCityName(String cityName) {
        return cityName != null && cityName.matches(CITY_NAME_PATTERN);
    }
}