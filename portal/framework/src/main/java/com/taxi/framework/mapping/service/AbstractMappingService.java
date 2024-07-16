package com.taxi.framework.mapping.service;

import com.taxi.framework.mapping.dto.DirectionsRequestDTO;
import com.taxi.framework.mapping.dto.DirectionsResponseDTO;
import org.springframework.web.client.RestTemplate;

/**
 * Abstract service providing basic mapping functionalities for directions.
 *
 * @param <R> Type of the DirectionsRequestDTO.
 * @param <S> Type of the DirectionsResponseDTO.
 */
public abstract class AbstractMappingService<R extends DirectionsRequestDTO, S extends DirectionsResponseDTO> {

    protected RestTemplate restTemplate;
    protected String apiKey;
    protected String directionsApiUrl;

    /**
     * Constructor to initialize the RestTemplate.
     *
     * @param restTemplate The RestTemplate used for API calls.
     */
    public AbstractMappingService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Gets the RestTemplate.
     *
     * @return The RestTemplate.
     */
    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    /**
     * Gets the API key.
     *
     * @return The API key.
     */
    public String getApiKey() {
        return apiKey;
    }

    /**
     * Gets the Directions API URL.
     *
     * @return The Directions API URL.
     */
    public String getDirectionsApiUrl() {
        return directionsApiUrl;
    }

    /**
     * Sets the API key.
     *
     * @param apiKey The API key to set.
     */
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * Sets the Directions API URL.
     *
     * @param directionsApiUrl The Directions API URL to set.
     */
    public void setDirectionsApiUrl(String directionsApiUrl) {
        this.directionsApiUrl = directionsApiUrl;
    }

    /**
     * Abstract method to get directions based on the provided request.
     *
     * @param request The directions request.
     * @return The directions' response.
     */
    public abstract S getDirections(R request);
}
