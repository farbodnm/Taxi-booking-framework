package com.taxi.framework.mapping.dto;

/**
 * Data Transfer Object for reverse geocoding response.
 */
public class ReverseGeocodingResponseDTO {
    private String address;

    /**
     * Default constructor.
     */
    public ReverseGeocodingResponseDTO() {
    }

    /**
     * Constructor with parameters.
     *
     * @param address the address details
     */
    public ReverseGeocodingResponseDTO(String address) {
        this.address = address;
    }

    // Getters and Setters

    /**
     * Gets the address details.
     *
     * @return the address details
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address details.
     *
     * @param address the address details
     */
    public void setAddress(String address) {
        this.address = address;
    }
}
