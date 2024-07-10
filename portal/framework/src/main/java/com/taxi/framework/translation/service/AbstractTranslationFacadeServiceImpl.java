package com.taxi.framework.translation.service;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.taxi.framework.translation.dto.BaseResponseTranslationDto;
import com.taxi.framework.translation.dto.BaseTranslationDto;

import java.io.IOException;
import java.util.List;

public class AbstractTranslationFacadeServiceImpl <T extends BaseTranslationDto, Y extends BaseResponseTranslationDto> implements TranslationFacadeService<T, Y> {

    private final TranslationService translationService;
    private final GeoIPLocationService geoIPLocationService;

    public AbstractTranslationFacadeServiceImpl(TranslationService translationService, GeoIPLocationService geoIPLocationService) {
        this.translationService = translationService;
        this.geoIPLocationService = geoIPLocationService;
    }

    @Override
    public Y GetTranslationContentByIP(T dto, String ip) throws IOException, GeoIp2Exception {
        String languageType = geoIPLocationService.getLocation(ip);

        Y translationDto = (Y) translationService.getTranslationByContentIdAndLanguageTypeLanguage(dto.getContentId(), languageType);

        return translationDto;
    }

    @Override
    public List<Y> GetSectionTranslationContentByIP(T dto, String ip) throws IOException, GeoIp2Exception {
        String languageType = geoIPLocationService.getLocation(ip);

        List<Y> result = translationService.getSectionTranslationContentIdAndLanguageTypeLanguage(dto.getSection(), languageType);

        return result;
    }
}
