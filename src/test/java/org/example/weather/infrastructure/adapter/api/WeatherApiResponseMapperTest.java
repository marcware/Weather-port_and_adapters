package org.example.weather.infrastructure.adapter.api;

import org.example.weather.domain.Weather;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WeatherApiResponseMapperTest {


    void testToDomain() {
        WeatherApiResponse response = new WeatherApiResponse();
        String city = "London";

        // Mapear el objeto WeatherApiResponse a Weather
        Weather weather = WeatherApiResponseMapper.toDomain(response, city);

        // Verificar que los datos se mapearon correctamente
        assertEquals("London", weather.getCity());
        assertEquals("Sunny", weather.getDescription());
        assertEquals(25.0, weather.getTemperature());
    }


    void testToDomainWithInvalidResponse() {
        // Crear un objeto WeatherApiResponse inválido
        WeatherApiResponse response = new WeatherApiResponse();

        // Verificar que se lanza una excepción al mapear un objeto inválido
        assertThrows(IllegalArgumentException.class, () -> {
            WeatherApiResponseMapper.toDomain(response, "London");
        });
    }
}
