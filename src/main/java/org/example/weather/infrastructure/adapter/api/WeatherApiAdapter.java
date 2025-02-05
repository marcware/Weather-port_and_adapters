package org.example.weather.infrastructure.adapter.api;

import org.example.weather.application.port.WeatherGetInformationByCityPort;
import org.example.weather.domain.Weather;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherApiAdapter implements WeatherGetInformationByCityPort {
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String API_URL =
            "https://api.openweathermap.org/data/2.5/weather?q={city}&appid={apiKey}&units=metric";

    @Override
    public Weather getWeatherForCity(String city) {
        WeatherApiResponse response =
                restTemplate.getForObject(API_URL, WeatherApiResponse.class, city, "your-api-key");
        return WeatherApiResponseMapper.toDomain(response, city);

    }
}
