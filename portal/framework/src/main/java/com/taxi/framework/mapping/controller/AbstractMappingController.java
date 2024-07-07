package com.taxi.framework.mapping.controller;

import com.taxi.framework.mapping.service.AbstractMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public abstract class AbstractMappingController {

    private final AbstractMappingService directionService;

    @Autowired
    public AbstractMappingController(AbstractMappingService directionService) {
        this.directionService = directionService;
    }

    @GetMapping
    public ResponseEntity<String> getDirections(
            @RequestParam String origin,
            @RequestParam String destination,
            @RequestParam String type,
            @RequestParam(required = false, defaultValue = "true") boolean withTraffic) {
        try {
            String response = directionService.getDirections(origin, destination, type, withTraffic);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
