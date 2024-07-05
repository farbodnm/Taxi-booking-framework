package com.taxi.framework.translation.dto;

public class GeoIP {
    private String ipAddress;
    private String country;

    public GeoIP(String ipAddress, String country) {
        this.ipAddress = ipAddress;
        this.country = country;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getCountry() {
        return country;
    }
}
