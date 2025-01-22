package org.example.weather.infrastructure.adapter.db;

import org.example.weather.application.port.WeatherPersistencePort;
import org.example.weather.domain.Weather;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class WeatherPersistenceAdapter implements WeatherPersistencePort {

    private final WeatherRepository weatherRepository;
    private final WeatherMapper weatherMapper;

    @Override
    public void saveWeather(Weather weather) {
        WeatherEntity weatherEntity = weatherMapper.toEntity(weather);
        weatherRepository.save(weatherEntity);
    }
}