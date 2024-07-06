package com.taxi.framework.mapping.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public abstract class AbstractMappingService {

    @Value("${neshan.api.key}")
    private String apiKey;

    private static final String API_URL = "https://api.neshan.org/v4/direction";



    public String getDirections(String origin, String destination, String type, boolean withTraffic) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Api-Key", apiKey);

        String url = withTraffic ? API_URL : API_URL + "/no-traffic";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("origin", origin)
                .queryParam("destination", destination)
                .queryParam("type", type);

        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                builder.toUriString(), HttpMethod.GET, entity, String.class);

        return response.getBody();
    }
}
