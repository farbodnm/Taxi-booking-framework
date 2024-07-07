package com.taxi.mapping.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.taxi.framework.mapping.service.AbstractMappingService;

@Service
public class MappingService extends AbstractMappingService {

    public MappingService(RestTemplate restTemplate) {
        super(restTemplate);
    }
}
