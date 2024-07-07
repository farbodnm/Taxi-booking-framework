package com.taxi.framework.mapping.dto;

public class DirectionsResponseDTO {
    private String route;

    public DirectionsResponseDTO() {
    }

    public DirectionsResponseDTO(String route) {
        this.route = route;
    }

    // Getters and Setters
    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }
}
