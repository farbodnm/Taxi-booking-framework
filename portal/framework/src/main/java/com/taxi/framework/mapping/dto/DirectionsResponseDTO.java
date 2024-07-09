package com.taxi.framework.mapping.dto;

/**
 * Data Transfer Object for directions response.
 */
public class DirectionsResponseDTO {
    private String route;

    /**
     * Default constructor.
     */
    public DirectionsResponseDTO() {
    }

    /**
     * Constructor with parameters.
     *
     * @param route the route details
     */
    public DirectionsResponseDTO(String route) {
        this.route = route;
    }

    // Getters and Setters

    /**
     * Gets the route details.
     *
     * @return the route details
     */
    public String getRoute() {
        return route;
    }

    /**
     * Sets the route details.
     *
     * @param route the route details
     */
    public void setRoute(String route) {
        this.route = route;
    }
}
