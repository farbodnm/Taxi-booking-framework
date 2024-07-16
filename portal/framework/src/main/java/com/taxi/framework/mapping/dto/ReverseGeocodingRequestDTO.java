package com.taxi.framework.mapping.dto;

public class ReverseGeocodingRequestDTO {
    private double lat;
    private double lng;

    public ReverseGeocodingRequestDTO() {
    }

    public ReverseGeocodingRequestDTO(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    // Getters and Setters
    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "ReverseGeocodingRequestDTO{" +
                "lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
