package com.taxi.mapping.dto;

import com.taxi.framework.mapping.dto.DirectionsRequestDTO;

public class NeshanDirectionsRequestDTO extends DirectionsRequestDTO {
    private boolean withTraffic;
    private String type;

    public NeshanDirectionsRequestDTO() {
    }

    public NeshanDirectionsRequestDTO(String origin, String destination, boolean withTraffic, String type) {
        super(origin, destination);
        this.withTraffic = withTraffic;
        this.type = type;
    }

    // Getters and Setters
    public boolean isWithTraffic() {
        return withTraffic;
    }

    public void setWithTraffic(boolean withTraffic) {
        this.withTraffic = withTraffic;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
