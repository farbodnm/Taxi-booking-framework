package com.taxi.mapping.dto;

import com.taxi.framework.mapping.dto.DirectionsResponseDTO;

public class NeshanDirectionsResponseDTO extends DirectionsResponseDTO {
    private String route;
    private String error;

    public NeshanDirectionsResponseDTO(String route, String error) {
        this.route = route;
        this.error = error;
    }

    public NeshanDirectionsResponseDTO() {

    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}

