package com.taxi.framework.mapping.service;

import com.taxi.framework.mapping.dto.DirectionsRequestDTO;
import com.taxi.framework.mapping.dto.ReverseGeocodingRequestDTO;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractMappingService<T extends DirectionsRequestDTO, U extends ReverseGeocodingRequestDTO> implements MappingService {

    protected RestTemplate restTemplate;
    protected String apiKey;

    public AbstractMappingService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    protected void validateApiKey() {
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalArgumentException("API key must not be null or empty");
        }
    }
}
