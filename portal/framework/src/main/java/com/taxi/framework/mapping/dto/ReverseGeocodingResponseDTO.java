package com.taxi.framework.mapping.dto;

public class ReverseGeocodingResponseDTO {
    private String address;

    public ReverseGeocodingResponseDTO() {
    }

    public ReverseGeocodingResponseDTO(String address) {
        this.address = address;
    }

    // Getters and Setters
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "ReverseGeocodingResponseDTO{" +
                "address='" + address + '\'' +
                '}';
    }
}
