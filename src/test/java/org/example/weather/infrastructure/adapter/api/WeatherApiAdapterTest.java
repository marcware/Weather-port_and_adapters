package org.example.weather.infrastructure.adapter.api;

import java.util.List;

import org.example.weather.domain.Weather;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

class WeatherApiAdapterTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private WeatherApiAdapter weatherApiAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    void testGetWeatherForCity() {
        String city = "London";
        WeatherApiResponse response = new WeatherApiResponse();

        WeatherApiResponse.WeatherDescription description =
                new WeatherApiResponse.WeatherDescription();
        description.setDescription("Sunny");

        WeatherApiResponse.Main main = new WeatherApiResponse.Main();
        main.setTemp(25.0);

        response.setWeather(List.of(description));
        response.setMain(main);


        when(restTemplate.getForObject(anyString(), eq(WeatherApiResponse.class), eq(city),
                anyString())).thenReturn(response);

        Weather weather = weatherApiAdapter.getWeatherForCity(city);

        assertEquals("London", weather.getCity());
        assertEquals("Sunny", weather.getDescription());
        assertEquals(25.0, weather.getTemperature());
    }
}
