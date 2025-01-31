package org.example.weather.infrastructure.adapter.db;

import org.example.weather.domain.Weather;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

class WeatherPersistenceAdapterTest {

    @Mock
    private WeatherRepository weatherRepository;

    @Mock
    private WeatherMapper weatherMapper;

    @InjectMocks
    private WeatherPersistenceAdapter weatherPersistenceAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveWeather() {
        Weather weather = new Weather("London", "Sunny", 25.0);
        WeatherEntity weatherEntity = new WeatherEntity(null, null, null, 0);

        when(weatherMapper.toEntity(weather)).thenReturn(weatherEntity);
        when(weatherRepository.save(weatherEntity)).thenReturn(weatherEntity);

        weatherPersistenceAdapter.saveWeather(weather);

        verify(weatherRepository).save(weatherEntity);
    }
}
