package com.taxi.framework.translation.service;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.taxi.framework.translation.dto.GeoIP;

import java.io.IOException;

public interface GeoIPLocationService {
    GeoIP getLocation(String ip) throws IOException, GeoIp2Exception;
}
