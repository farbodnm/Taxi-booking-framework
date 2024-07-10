package com.taxi.framework.translation.service;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.taxi.framework.translation.dto.BaseResponseTranslationDto;
import com.taxi.framework.translation.dto.BaseTranslationDto;

import java.io.IOException;
import java.util.List;


public interface TranslationFacadeService <T extends BaseTranslationDto, Y extends BaseResponseTranslationDto>{
    Y GetTranslationContentByIP(T dto, String ip) throws IOException, GeoIp2Exception;
    List<Y> GetSectionTranslationContentByIP(T dto, String ip) throws IOException, GeoIp2Exception;
}
