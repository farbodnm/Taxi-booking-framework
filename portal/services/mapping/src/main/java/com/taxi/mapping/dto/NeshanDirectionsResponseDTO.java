package com.taxi.mapping.dto;

import com.taxi.framework.mapping.dto.DirectionsResponseDTO;

public class NeshanDirectionsResponseDTO extends DirectionsResponseDTO {
    private String detailedRoute;

    public NeshanDirectionsResponseDTO() {
    }

    public NeshanDirectionsResponseDTO(String route, String detailedRoute) {
        super(route);
        this.detailedRoute = detailedRoute;
    }

    // Getters and Setters
    public String getDetailedRoute() {
        return detailedRoute;
    }

    public void setDetailedRoute(String detailedRoute) {
        this.detailedRoute = detailedRoute;
    }
}
