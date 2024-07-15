package com.taxi.mapping.controller;

import com.taxi.framework.mapping.controller.AbstractMappingController;
import com.taxi.mapping.dto.NeshanDirectionsRequestDTO;
import com.taxi.mapping.dto.NeshanDirectionsResponseDTO;
import com.taxi.mapping.service.NeshanMappingService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Controller for handling Neshan mapping requests.
 */
@RestController
@RequestMapping("/api/v1/neshan")
public class NeshanMappingController extends AbstractMappingController<NeshanDirectionsRequestDTO, NeshanDirectionsResponseDTO> {

    /**
     * Constructor to initialize the NeshanMappingService.
     *
     * @param mappingService The mapping service used to get directions.
     */
    @Autowired
    public NeshanMappingController(NeshanMappingService mappingService) {
        super(mappingService);
    }

    /**
     * Endpoint to get directions based on the provided parameters.
     *
     * @param params Parameters for the directions request.
     * @return ResponseEntity containing the directions response or an error response.
     */
    @GetMapping("/directions")
    public ResponseEntity<NeshanDirectionsResponseDTO> getDirections(@RequestParam Map<String, String> params) {
        return super.getDirections(params);
    }

    /**
     * Creates a Neshan directions request from the provided parameters.
     *
     * @param params Parameters for creating the directions request.
     * @return A Neshan directions request.
     */
    @Override
    protected NeshanDirectionsRequestDTO createDirectionsRequest(@NotNull Map<String, String> params) {
        String origin = params.get("origin");
        String destination = params.get("destination");
        boolean withTraffic = Boolean.parseBoolean(params.getOrDefault("withTraffic", "true"));
        String type = params.getOrDefault("type", "car");
        return new NeshanDirectionsRequestDTO(origin, destination, withTraffic, type);
    }

    /**
     * Creates an error response based on the provided exception.
     *
     * @param e The exception that occurred.
     * @return An error response.
     */
    @Override
    protected NeshanDirectionsResponseDTO createErrorResponse(Exception e) {
        NeshanDirectionsResponseDTO response = new NeshanDirectionsResponseDTO();
        response.setError(e.getMessage());
        return response;
    }
}
