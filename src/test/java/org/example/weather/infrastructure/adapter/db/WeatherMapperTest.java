package org.example.weather.infrastructure.adapter.db;

import org.example.weather.domain.Weather;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

class WeatherMapperTest {

    private final WeatherMapper weatherMapper = new WeatherMapper();

    @Test
    void testToEntity() {
        Weather weather = new Weather("London", "Sunny", 25.0);
        WeatherEntity weatherEntity = weatherMapper.toEntity(weather);

        assertNotNull(weatherEntity);
        assertEquals("London", weatherEntity.getCity());
        assertEquals("Sunny", weatherEntity.getDescription());
        assertEquals(25.0, weatherEntity.getTemperature());
    }

    @Test
    void testToDomain() {
        WeatherEntity weatherEntity = WeatherEntity.builder().city("London").description("Sunny")
                .temperature(25.0).build();
        Weather weather = weatherMapper.toDomain(weatherEntity);

        assertNotNull(weather);
        assertEquals("London", weather.getCity());
        assertEquals("Sunny", weather.getDescription());
        assertEquals(25.0, weather.getTemperature());
    }
}
