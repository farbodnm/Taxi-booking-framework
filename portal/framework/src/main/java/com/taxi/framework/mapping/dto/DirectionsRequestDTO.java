package com.taxi.framework.mapping.dto;

/**
 * Data Transfer Object for directions request.
 */
public class DirectionsRequestDTO {
    private String origin;
    private String destination;
    private String type;
    private boolean withTraffic;

    /**
     * Default constructor.
     */
    public DirectionsRequestDTO() {
    }

    /**
     * Constructor with parameters.
     *
     * @param origin the origin location
     * @param destination the destination location
     * @param type the type of route
     * @param withTraffic whether to consider traffic
     */
    public DirectionsRequestDTO(String origin, String destination, String type, boolean withTraffic) {
        this.origin = origin;
        this.destination = destination;
        this.type = type;
        this.withTraffic = withTraffic;
    }

    // Getters and Setters

    /**
     * Gets the origin location.
     *
     * @return the origin location
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Sets the origin location.
     *
     * @param origin the origin location
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * Gets the destination location.
     *
     * @return the destination location
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Sets the destination location.
     *
     * @param destination the destination location
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * Gets the type of route.
     *
     * @return the type of route
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of route.
     *
     * @param type the type of route
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Checks if traffic should be considered.
     *
     * @return true if traffic should be considered, false otherwise
     */
    public boolean isWithTraffic() {
        return withTraffic;
    }

    /**
     * Sets whether traffic should be considered.
     *
     * @param withTraffic true if traffic should be considered, false otherwise
     */
    public void setWithTraffic(boolean withTraffic) {
        this.withTraffic = withTraffic;
    }
}
