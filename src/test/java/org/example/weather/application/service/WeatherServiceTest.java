package org.example.weather.application.service;

import org.example.weather.application.port.WeatherPersistencePort;
import org.example.weather.application.port.WeatherGetInformationByCityPort;
import org.example.weather.domain.CityValidator;
import org.example.weather.domain.Weather;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

class WeatherServiceTest {

    @Mock
    private WeatherGetInformationByCityPort weatherPort;

    @Mock
    private WeatherPersistencePort weatherPersistencePort;

    @Mock
    private CityValidator cityValidator;

    @InjectMocks
    private WeatherService weatherService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetWeather() {
        String city = "London";
        Weather weather = new Weather(city, "Sunny", 25.0);

        when(cityValidator.isValidCityName(city)).thenReturn(true);
        when(weatherPort.getWeatherForCity(city)).thenReturn(weather);

        Weather result = weatherService.getWeather(city);

        verify(weatherPersistencePort).saveWeather(weather);
        assertEquals(weather, result);
    }

    @Test
    void testGetWeatherInvalidCity() {
        String city = "InvalidCity";

        when(cityValidator.isValidCityName(city)).thenReturn(false);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> weatherService.getWeather(city));
        
        assertEquals("Invalid city name", exception.getMessage());
    }
}
