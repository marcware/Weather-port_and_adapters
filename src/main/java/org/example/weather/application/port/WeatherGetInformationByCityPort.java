package org.example.weather.application.port;

import org.example.weather.domain.Weather;

/**
 * Interfaz para el puerto de obtención del clima.
 * Define el contrato para obtener la información del clima de una ciudad específica.
 */
public interface WeatherGetInformationByCityPort {
    /**
     * Obtiene la información del clima para una ciudad específica.
     * 
     * @param city el nombre de la ciudad para la cual se desea obtener el clima.
     * @return un objeto Weather que contiene la información del clima de la ciudad especificada.
     */
    Weather getWeatherForCity(String city);
}
