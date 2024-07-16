package com.taxi.mapping.dto;

import com.taxi.framework.mapping.dto.ReverseGeocodingResponseDTO;

public class NeshanReverseGeocodingResponseDTO extends ReverseGeocodingResponseDTO {
    private String detailedAddressInfo;

    public NeshanReverseGeocodingResponseDTO() {
    }

    public NeshanReverseGeocodingResponseDTO(String address) {
        super(address);
    }

    public NeshanReverseGeocodingResponseDTO(String address, String detailedAddressInfo) {
        super(address);
        this.detailedAddressInfo = detailedAddressInfo;
    }

    // Getters and Setters
    public String getDetailedAddressInfo() {
        return detailedAddressInfo;
    }

    public void setDetailedAddressInfo(String detailedAddressInfo) {
        this.detailedAddressInfo = detailedAddressInfo;
    }
}
