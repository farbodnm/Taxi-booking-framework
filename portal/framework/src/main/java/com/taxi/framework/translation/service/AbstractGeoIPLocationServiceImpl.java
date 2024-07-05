package com.taxi.framework.translation.service;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CountryResponse;
import com.taxi.framework.translation.dto.GeoIP;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

public class AbstractGeoIPLocationServiceImpl implements GeoIPLocationService {
    private DatabaseReader dbReader;

    public AbstractGeoIPLocationServiceImpl(ResourceLoader resourceLoader) throws IOException {;
        File database = resourceLoader.getResource("classpath:GeoLite2-Country.mmdb").getFile();
        dbReader = new DatabaseReader.Builder(database).build();
    }

    @Override
    public GeoIP getLocation(String ip) throws IOException, GeoIp2Exception {

        InetAddress ipAddress = InetAddress.getByName(ip);
        CountryResponse response = dbReader.country(ipAddress);

        String countryName = response.getCountry().getName();

        return new GeoIP(ip, countryName);
    }

}
