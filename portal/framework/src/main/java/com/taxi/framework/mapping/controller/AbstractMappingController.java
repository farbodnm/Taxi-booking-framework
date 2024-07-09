package com.taxi.framework.mapping.controller;

import com.taxi.framework.mapping.dto.DirectionsRequestDTO;
import com.taxi.framework.mapping.dto.DirectionsResponseDTO;
import com.taxi.framework.mapping.dto.ReverseGeocodingRequestDTO;
import com.taxi.framework.mapping.dto.ReverseGeocodingResponseDTO;
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

    @GetMapping("/directions")
    public ResponseEntity<DirectionsResponseDTO> getDirections(
            @RequestParam String origin,
            @RequestParam String destination,
            @RequestParam String type,
            @RequestParam(required = false, defaultValue = "true") boolean withTraffic) {
        try {
            DirectionsRequestDTO request = new DirectionsRequestDTO(origin, destination, type, withTraffic);
            DirectionsResponseDTO response = directionService.getDirections(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new DirectionsResponseDTO(e.getMessage()));
        }
    }

    @GetMapping("/reverse-geocoding")
    public ResponseEntity<ReverseGeocodingResponseDTO> getReverseGeocoding(
            @RequestParam double lat,
            @RequestParam double lng) {
        try {
            ReverseGeocodingRequestDTO request = new ReverseGeocodingRequestDTO(lat, lng);
            ReverseGeocodingResponseDTO response = directionService.getReverseGeocoding(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ReverseGeocodingResponseDTO(e.getMessage()));
        }
    }
}
