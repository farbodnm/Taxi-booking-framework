package com.taxi.pay.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Configuration class for the Payment Application.
 * This class defines beans for configuring application components.
 */
@Configuration
public class PaymentAppConfig {

    /**
     * Provides a RestTemplate bean.
     *
     * @return a RestTemplate instance for making HTTP requests
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
