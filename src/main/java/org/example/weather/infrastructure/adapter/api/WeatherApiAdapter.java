package org.example.weather.infrastructure.adapter.api;

import org.example.weather.application.port.WeatherPort;
import org.example.weather.domain.Weather;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherApiAdapter implements WeatherPort {
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather?q={city}&appid={apiKey}&units=metric";

    @Override
    public Weather getWeatherForCity(String city) {
        WeatherApiResponse response = restTemplate.getForObject(API_URL, WeatherApiResponse.class, city,
                "your-api-key");
        if (response == null || response.getWeather() == null || response.getWeather().isEmpty()
                || response.getMain() == null) {
            throw new RuntimeException("Invalid response from weather API");
        }
        return new Weather(
                city,
                response.getWeather().get(0).getDescription(),
                response.getMain().getTemp());
    }
}