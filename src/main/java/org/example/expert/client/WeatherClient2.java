package org.example.expert.client;

import org.example.expert.client.dto.WeatherDto2;
import org.example.expert.domain.common.exception.ServerException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Component
public class WeatherClient2 {

    private final RestTemplate restTemplate;

    public WeatherClient2(RestTemplateBuilder restTemplate) {
        this.restTemplate = restTemplate.build();
    }

    public String getTodayWeather() {
        ResponseEntity<WeatherDto2[]> responseEntity = restTemplate.getForEntity(buildWeaherApiUri(), WeatherDto2[].class);

        if(!HttpStatus.OK.equals(responseEntity.getStatusCode())) {
            throw new ServerException("날씨 데이터를 가져오는데 살패했습니다. 상태 코드 : " + responseEntity.getStatusCode());
        }

        WeatherDto2[] weatherDto2s = responseEntity.getBody();
        if (weatherDto2s == null || weatherDto2s.length == 0) {
            throw new ServerException("날씨 데이터가 없습니다.");
        }

        String today = getCurrentDate();

        for(WeatherDto2 weatherDto2 : weatherDto2s) {
            if (today.equals(weatherDto2.getDate())) {
                return weatherDto2.getWeather();
            }
        }
        throw new ServerException("오늘에 해당하는 날씨 데이터를 찾을수 없습니다.");
    }

    private URI buildWeaherApiUri() {
        return UriComponentsBuilder
                .fromUriString("https://f-api.github.io")
                .path("/f-api/weather.json")
                .encode()
                .build()
                .toUri();
    }

    private String getCurrentDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd");
        return LocalDate.now().format(formatter);
    }

}
