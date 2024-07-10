package com.taxi.mapping.dto;

import com.taxi.framework.mapping.dto.ReverseGeocodingRequestDTO;

public class NeshanReverseGeocodingRequestDTO extends ReverseGeocodingRequestDTO {
    public NeshanReverseGeocodingRequestDTO() {
    }

    public NeshanReverseGeocodingRequestDTO(double lat, double lng) {
        super(lat, lng);
    }
}
