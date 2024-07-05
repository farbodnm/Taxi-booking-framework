package com.taxi.translation.service;

import com.taxi.framework.translation.service.AbstractGeoIPLocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class GeoIpLocationServiceImpl extends AbstractGeoIPLocationServiceImpl {

    @Autowired
    public GeoIpLocationServiceImpl(ResourceLoader resourceLoader) throws IOException {
        super(resourceLoader);
    }
}
