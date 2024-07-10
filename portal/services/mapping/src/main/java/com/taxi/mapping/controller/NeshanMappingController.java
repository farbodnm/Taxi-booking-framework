package com.taxi.mapping.controller;

import com.taxi.framework.mapping.controller.AbstractMappingController;
import com.taxi.framework.mapping.dto.DirectionsResponseDTO;
import com.taxi.framework.mapping.dto.ReverseGeocodingRequestDTO;
import com.taxi.framework.mapping.dto.ReverseGeocodingResponseDTO;
import com.taxi.framework.mapping.service.MappingService;
import com.taxi.mapping.dto.NeshanDirectionsRequestDTO;
import com.taxi.mapping.dto.NeshanReverseGeocodingRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/neshan")
public class NeshanMappingController extends AbstractMappingController {

    @Autowired
    public NeshanMappingController(MappingService mappingService) {
        super(mappingService);
    }

    @GetMapping("/directions")
    public ResponseEntity<DirectionsResponseDTO> getDirections(
            @RequestParam String origin,
            @RequestParam String destination,
            @RequestParam(required = false, defaultValue = "true") boolean withTraffic,
            @RequestParam(required = false, defaultValue = "driving") String type) {
        try {
            NeshanDirectionsRequestDTO request = new NeshanDirectionsRequestDTO(origin, destination, withTraffic, type);
            DirectionsResponseDTO response = getMappingService().getDirections(request);
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
            ReverseGeocodingRequestDTO request = new NeshanReverseGeocodingRequestDTO(lat, lng);
            ReverseGeocodingResponseDTO response = getMappingService().getReverseGeocoding(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ReverseGeocodingResponseDTO(e.getMessage()));
        }
    }
}
