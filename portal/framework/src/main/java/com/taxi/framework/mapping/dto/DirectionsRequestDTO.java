package com.taxi.framework.mapping.dto;

public class DirectionsRequestDTO {
    private String origin;
    private String destination;
    private String type;
    private boolean withTraffic;

    public DirectionsRequestDTO() {
    }

    public DirectionsRequestDTO(String origin, String destination, String type, boolean withTraffic) {
        this.origin = origin;
        this.destination = destination;
        this.type = type;
        this.withTraffic = withTraffic;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isWithTraffic() {
        return withTraffic;
    }

    public void setWithTraffic(boolean withTraffic) {
        this.withTraffic = withTraffic;
    }
}
