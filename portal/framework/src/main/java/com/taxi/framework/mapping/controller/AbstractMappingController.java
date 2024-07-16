package com.taxi.framework.mapping.controller;

import com.taxi.framework.mapping.dto.DirectionsRequestDTO;
import com.taxi.framework.mapping.dto.DirectionsResponseDTO;
import com.taxi.framework.mapping.service.AbstractMappingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Abstract controller providing basic mapping functionalities for directions.
 *
 * @param <R> Type of the DirectionsRequestDTO.
 * @param <S> Type of the DirectionsResponseDTO.
 */
public abstract class AbstractMappingController<R extends DirectionsRequestDTO, S extends DirectionsResponseDTO> {

    protected final AbstractMappingService<R, S> mappingService;

    /**
     * Constructor to initialize the mapping service.
     *
     * @param mappingService The mapping service used to get directions.
     */
    public AbstractMappingController(AbstractMappingService<R, S> mappingService) {
        this.mappingService = mappingService;
    }

    /**
     * Gets the mapping service.
     *
     * @return The mapping service.
     */
    protected AbstractMappingService<R, S> getMappingService() {
        return this.mappingService;
    }

    /**
     * Gets directions based on the provided parameters.
     *
     * @param params Parameters for the directions request.
     * @return ResponseEntity containing the directions response or an error response.
     */
    public ResponseEntity<S> getDirections(@RequestParam Map<String, String> params) {
        try {
            R request = this.createDirectionsRequest(params);
            S response = mappingService.getDirections(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            S errorResponse = this.createErrorResponse(e);
            return ResponseEntity.status(500).body(errorResponse);
        }
    }

    /**
     * Creates a directions request from the provided parameters.
     *
     * @param params Parameters for creating the directions request.
     * @return A directions request.
     */
    protected abstract R createDirectionsRequest(Map<String, String> params);

    /**
     * Creates an error response based on the provided exception.
     *
     * @param e The exception that occurred.
     * @return An error response.
     */
    protected abstract S createErrorResponse(Exception e);
}
