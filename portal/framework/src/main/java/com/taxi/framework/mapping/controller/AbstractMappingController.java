package com.taxi.framework.mapping.controller;

import com.taxi.framework.mapping.dto.DirectionsRequestDTO;
import com.taxi.framework.mapping.dto.DirectionsResponseDTO;
import com.taxi.framework.mapping.dto.ReverseGeocodingRequestDTO;
import com.taxi.framework.mapping.dto.ReverseGeocodingResponseDTO;
import com.taxi.framework.mapping.service.MappingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public abstract class AbstractMappingController {

    private final MappingService mappingService;

    public AbstractMappingController(MappingService mappingService) {
        this.mappingService = mappingService;
    }

    protected MappingService getMappingService() {
        return this.mappingService;
    }

    @GetMapping("/directions")
    public ResponseEntity<DirectionsResponseDTO> getDirections(
            @RequestParam String origin,
            @RequestParam String destination) {
        try {
            DirectionsRequestDTO request = new DirectionsRequestDTO(origin, destination);
            DirectionsResponseDTO response = mappingService.getDirections(request);
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
            ReverseGeocodingResponseDTO response = mappingService.getReverseGeocoding(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ReverseGeocodingResponseDTO(e.getMessage()));
        }
    }
}
