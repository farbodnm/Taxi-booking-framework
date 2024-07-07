package com.taxi.mapping.controller;

import com.taxi.framework.mapping.controller.AbstractMappingController;
import com.taxi.framework.mapping.service.AbstractMappingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/directions")
public class MappingController extends AbstractMappingController {

    public MappingController(AbstractMappingService directionService) {
        super(directionService);
    }
}
