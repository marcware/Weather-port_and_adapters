package org.example.weather.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Data
@Setter
@AllArgsConstructor
@Builder
public class Weather {
    private String city;
    private String description;
    private double temperature;



}