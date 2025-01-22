package org.example.weather.infrastructure.adapter.db;

import org.example.weather.domain.Weather;
import org.springframework.stereotype.Component;

@Component
public class WeatherMapper {

    public WeatherEntity toEntity(Weather weather) {
        if (weather == null) {
            return null;
        }
        return WeatherEntity.builder()
            .city(weather.getCity())
            .description(weather.getDescription())
            .temperature(weather.getTemperature())
            .build();
    }

    public Weather toDomain(WeatherEntity weatherEntity) {
        if (weatherEntity == null) {
            return null;
        }
        return Weather.builder()
            .city(weatherEntity.getCity())
            .description(weatherEntity.getDescription())
            .temperature(weatherEntity.getTemperature())
            .build();
    }
}