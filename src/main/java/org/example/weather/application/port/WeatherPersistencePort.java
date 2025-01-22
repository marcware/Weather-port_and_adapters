package org.example.weather.application.port;

import org.example.weather.domain.Weather;

/**
 * Interfaz para el puerto de persistencia del clima.
 * Define el contrato para guardar la información del clima.
 */
public interface WeatherPersistencePort {
    /**
     * Guarda la información del clima.
     * 
     * @param weather el objeto Weather que contiene la información del clima a guardar.
     */
    void saveWeather(Weather weather);
}