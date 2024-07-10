package com.taxi.framework.mapping.service;

import com.taxi.framework.mapping.dto.DirectionsRequestDTO;
import com.taxi.framework.mapping.dto.DirectionsResponseDTO;
import com.taxi.framework.mapping.dto.ReverseGeocodingRequestDTO;
import com.taxi.framework.mapping.dto.ReverseGeocodingResponseDTO;

public interface MappingService {
    DirectionsResponseDTO getDirections(DirectionsRequestDTO request);
    ReverseGeocodingResponseDTO getReverseGeocoding(ReverseGeocodingRequestDTO request);
}
