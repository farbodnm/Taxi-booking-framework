package com.taxi.mapping.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Configuration class for application beans.
 */
@Configuration
public class AppConfig {

    /**
     * Bean for RestTemplate.
     *
     * @return a new RestTemplate instance
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
