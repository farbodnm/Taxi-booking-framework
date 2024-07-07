package com.taxi.mapping.service;

import com.taxi.framework.mapping.service.AbstractMappingService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MappingService extends AbstractMappingService {

    public MappingService(RestTemplate restTemplate) {
        super(restTemplate);
    }
}
