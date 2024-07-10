package com.taxi.framework.translation.service;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.taxi.framework.translation.dto.BaseGeoIpLocationDto;
import com.taxi.framework.translation.dto.BaseGeoIpLocationResponseDto;
import com.taxi.framework.translation.dto.GeoIP;

import java.io.IOException;

public interface GeoIPLocationService<T extends BaseGeoIpLocationDto, Y extends BaseGeoIpLocationResponseDto> {
    String getLocation(String ip) throws IOException, GeoIp2Exception;
}
