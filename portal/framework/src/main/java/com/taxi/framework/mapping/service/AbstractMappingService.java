package com.taxi.framework.mapping.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractMappingService implements MappingService {

    @Value("${map.api.key}")
    protected String apiKey;

    protected RestTemplate restTemplate;

    public AbstractMappingService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    protected void validateApiKey() {
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalArgumentException("API key must not be null or empty");
        }
    }
}
