package org.example.weather.application.service;

import org.example.weather.application.port.WeatherPersistencePort;
import org.example.weather.application.port.WeatherPort;
import org.example.weather.domain.CityValidator;
import org.example.weather.domain.Weather;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private final WeatherPort weatherPort;
    private final WeatherPersistencePort weatherPersistencePort;
    private final CityValidator cityValidator;

    /**
     * Obtiene la información del clima para una ciudad específica.
     * 
     * @param city Nombre de la ciudad
     * @return Información del clima
     * @throws IllegalArgumentException si el nombre de la ciudad no es válido
     */
    public Weather getWeather(String city) {
        if (!cityValidator.isValidCityName(city)) {
            throw new IllegalArgumentException("Invalid city name: " + city);
        }
        Weather weather = weatherPort.getWeatherForCity(city);
        weatherPersistencePort.saveWeather(weather);
        return weather;
    }
}