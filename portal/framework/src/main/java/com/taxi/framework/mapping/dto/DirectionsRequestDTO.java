package com.taxi.framework.mapping.dto;

public class DirectionsRequestDTO {
    private String origin;
    private String destination;

    public DirectionsRequestDTO() {
    }

    public DirectionsRequestDTO(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
    }

    // Getters and Setters
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
