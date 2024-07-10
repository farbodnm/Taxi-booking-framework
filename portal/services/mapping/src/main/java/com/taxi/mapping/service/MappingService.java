package com.taxi.mapping.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.taxi.framework.mapping.service.AbstractMappingService;

/**
 * Implementation of mapping service.
 */
@Service
public class MappingService extends AbstractMappingService {

    /**
     * Constructor for MappingService.
     *
     * @param restTemplate the RestTemplate to be used for API requests
     */
    public MappingService(RestTemplate restTemplate) {
        super(restTemplate);
    }
}
