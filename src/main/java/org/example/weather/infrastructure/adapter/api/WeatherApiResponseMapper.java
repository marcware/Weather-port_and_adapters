package org.example.weather.infrastructure.adapter.api;

import org.example.weather.domain.Weather;

public class WeatherApiResponseMapper {

    public static Weather toDomain(WeatherApiResponse response, String city) {
        if (response == null || response.getWeather() == null || response.getWeather().isEmpty()
                || response.getMain() == null) {
            throw new IllegalArgumentException("Invalid WeatherApiResponse");
        }

        String description = response.getWeather().get(0).getDescription();
        double temperature = response.getMain().getTemp();

        return new Weather(city, description, temperature);
    }
}
