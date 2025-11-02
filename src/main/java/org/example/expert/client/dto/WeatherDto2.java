package org.example.expert.client.dto;

import lombok.Getter;

@Getter
public class WeatherDto2 {

    private final String date;
    private final String weather;

    public WeatherDto2(String date, String weather) {
        this.date = date;
        this.weather = weather;
    }

}
