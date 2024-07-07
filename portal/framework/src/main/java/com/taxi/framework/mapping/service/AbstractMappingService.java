package com.taxi.framework.mapping.service;

import com.taxi.framework.mapping.dto.DirectionsRequestDTO;
import com.taxi.framework.mapping.dto.DirectionsResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public abstract class AbstractMappingService {

    @Value("${neshan.api.key}")
    private String apiKey;

    private static final String API_URL = "https://api.neshan.org/v4/direction";

    private final RestTemplate restTemplate;

    public AbstractMappingService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public DirectionsResponseDTO getDirections(DirectionsRequestDTO request) {
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalArgumentException("API key must not be null or empty");
        }

        HttpHeaders headers = new HttpHeaders();
        headers.set("Api-Key", apiKey);

        String url = request.isWithTraffic() ? API_URL : API_URL + "/no-traffic";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("origin", request.getOrigin())
                .queryParam("destination", request.getDestination())
                .queryParam("type", request.getType());

        HttpEntity<?> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    builder.toUriString(), HttpMethod.GET, entity, String.class);

            return new DirectionsResponseDTO(response.getBody());
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while fetching directions: " + e.getMessage(), e);
        }
    }
}
