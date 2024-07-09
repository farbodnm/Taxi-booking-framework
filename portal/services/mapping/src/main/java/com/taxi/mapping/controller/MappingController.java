package com.taxi.mapping.controller;

import com.taxi.framework.mapping.controller.AbstractMappingController;
import com.taxi.framework.mapping.service.AbstractMappingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for mapping services.
 */
@RestController
@RequestMapping("/api/v1")
public class MappingController extends AbstractMappingController {

    /**
     * Constructor for MappingController.
     *
     * @param directionService the mapping service to be used
     */
    public MappingController(AbstractMappingService directionService) {
        super(directionService);
    }
}
