package com.taxi.mapping.service;

import com.taxi.framework.mapping.dto.DirectionsRequestDTO;
import com.taxi.framework.mapping.dto.DirectionsResponseDTO;
import com.taxi.framework.mapping.dto.ReverseGeocodingRequestDTO;
import com.taxi.framework.mapping.dto.ReverseGeocodingResponseDTO;
import com.taxi.framework.mapping.service.AbstractMappingService;
import com.taxi.mapping.dto.NeshanDirectionsRequestDTO;
import com.taxi.mapping.dto.NeshanDirectionsResponseDTO;
import com.taxi.mapping.dto.NeshanReverseGeocodingRequestDTO;
import com.taxi.mapping.dto.NeshanReverseGeocodingResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class NeshanMappingService extends AbstractMappingService<NeshanDirectionsRequestDTO, NeshanReverseGeocodingRequestDTO> {

    @Value("${neshan.api.url.directions}")
    private String directionsApiUrl;

    @Value("${neshan.api.url.reverse-geocoding}")
    private String reverseGeocodingApiUrl;

    public NeshanMappingService(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    public DirectionsResponseDTO getDirections(DirectionsRequestDTO request) {
        validateApiKey();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Api-Key", apiKey);

        NeshanDirectionsRequestDTO neshanRequest = (NeshanDirectionsRequestDTO) request;
        String url = neshanRequest.isWithTraffic() ? directionsApiUrl : directionsApiUrl + "/no-traffic";

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

    @Override
    public ReverseGeocodingResponseDTO getReverseGeocoding(ReverseGeocodingRequestDTO request) {
        validateApiKey();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Api-Key", apiKey);

        NeshanReverseGeocodingRequestDTO neshanRequest = (NeshanReverseGeocodingRequestDTO) request;

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(reverseGeocodingApiUrl)
                .queryParam("lat", neshanRequest.getLat())
                .queryParam("lng", neshanRequest.getLng());

        HttpEntity<?> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    builder.toUriString(), HttpMethod.GET, entity, String.class);

            return new NeshanReverseGeocodingResponseDTO(response.getBody());
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while fetching reverse geocoding: " + e.getMessage(), e);
        }
    }
}
