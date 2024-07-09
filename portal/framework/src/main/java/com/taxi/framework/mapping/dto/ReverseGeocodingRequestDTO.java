package com.taxi.framework.mapping.dto;

/**
 * Data Transfer Object for reverse geocoding request.
 */
public class ReverseGeocodingRequestDTO {
    private double lat;
    private double lng;

    /**
     * Default constructor.
     */
    public ReverseGeocodingRequestDTO() {
    }

    /**
     * Constructor with parameters.
     *
     * @param lat the latitude
     * @param lng the longitude
     */
    public ReverseGeocodingRequestDTO(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    // Getters and Setters

    /**
     * Gets the latitude.
     *
     * @return the latitude
     */
    public double getLat() {
        return lat;
    }

    /**
     * Sets the latitude.
     *
     * @param lat the latitude
     */
    public void setLat(double lat) {
        this.lat = lat;
    }

    /**
     * Gets the longitude.
     *
     * @return the longitude
     */
    public double getLng() {
        return lng;
    }

    /**
     * Sets the longitude.
     *
     * @param lng the longitude
     */
    public void setLng(double lng) {
        this.lng = lng;
    }
}
