package com.taxi.mapping.config;

import com.taxi.framework.mapping.service.AbstractMappingService;
import com.taxi.mapping.service.NeshanMappingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Value("${neshan.api.key}")
    private String apiKey;

    @Value("${neshan.api.url.directions}")
    private String directionsApiUrl;

    @Value("${neshan.api.url.reverse-geocoding}")
    private String reverseGeocodingApiUrl;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    @Primary
    public AbstractMappingService mappingService(RestTemplate restTemplate) {
        NeshanMappingService neshanMappingService = new NeshanMappingService(restTemplate);
        neshanMappingService.setApiKey(apiKey);
        neshanMappingService.setDirectionsApiUrl(directionsApiUrl);
        return neshanMappingService;
    }
}
