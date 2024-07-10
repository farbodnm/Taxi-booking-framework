package com.taxi.mapping.dto;

import com.taxi.framework.mapping.dto.ReverseGeocodingResponseDTO;

public class NeshanReverseGeocodingResponseDTO extends ReverseGeocodingResponseDTO {
    public NeshanReverseGeocodingResponseDTO() {
    }

    public NeshanReverseGeocodingResponseDTO(String address) {
        super(address);
    }
}
