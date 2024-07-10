package com.taxi.mapping.config;

import com.taxi.framework.mapping.service.MappingService;
import com.taxi.mapping.service.NeshanMappingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Value("${neshan.api.key}")
    private String apiKey; // Corrected variable name

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    @Primary
    public MappingService mappingService(RestTemplate restTemplate) {
        NeshanMappingService neshanMappingService = new NeshanMappingService(restTemplate);
        // Set the API key provided by the user
        neshanMappingService.setApiKey(apiKey);
        return neshanMappingService;
    }
}
