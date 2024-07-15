package com.taxi.mapping.service;

import com.taxi.framework.mapping.service.AbstractMappingService;
import com.taxi.mapping.dto.NeshanDirectionsRequestDTO;
import com.taxi.mapping.dto.NeshanDirectionsResponseDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Service for handling Neshan mapping requests.
 */
@Service
public class NeshanMappingService extends AbstractMappingService<NeshanDirectionsRequestDTO, NeshanDirectionsResponseDTO> {

    /**
     * Constructor to initialize the RestTemplate.
     *
     * @param restTemplate The RestTemplate used for API calls.
     */
    public NeshanMappingService(RestTemplate restTemplate) {
        super(restTemplate);
    }

    /**
     * Validates the API key.
     *
     * @throws IllegalArgumentException if the API key is null or empty.
     */
    private void validateApiKey() {
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalArgumentException("API key must not be null or empty");
        }
    }

    /**
     * Gets directions based on the provided request.
     *
     * @param request The directions request.
     * @return The directions' response.
     */
    @Override
    public NeshanDirectionsResponseDTO getDirections(NeshanDirectionsRequestDTO request) {
        validateApiKey();
        NeshanDirectionsRequestDTO neshanRequest = (NeshanDirectionsRequestDTO) request;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Api-Key", apiKey);

        String url = neshanRequest.isWithTraffic() ? getDirectionsApiUrl() : getDirectionsApiUrl() + "/no-traffic";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("origin", neshanRequest.getOrigin())
                .queryParam("destination", neshanRequest.getDestination())
                .queryParam("type", neshanRequest.getType());

        HttpEntity<?> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    builder.toUriString(), HttpMethod.GET, entity, String.class);

            return new NeshanDirectionsResponseDTO(response.getBody(), "Detailed route information");
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while fetching directions: " + e.getMessage(), e);
        }
    }
}
