package com.taxi.translation.service;

import com.taxi.framework.translation.dto.BaseResponseTranslationDto;
import com.taxi.framework.translation.dto.BaseTranslationDto;
import com.taxi.framework.translation.service.AbstractTranslationFacadeServiceImpl;
import com.taxi.framework.translation.service.GeoIPLocationService;
import com.taxi.framework.translation.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranslateFacadeServiceImpl extends AbstractTranslationFacadeServiceImpl<BaseTranslationDto, BaseResponseTranslationDto> {

    @Autowired
    private TranslationServiceImpl translationService;
    @Autowired
    private GeoIPLocationService geoIPLocationService;
    public TranslateFacadeServiceImpl(TranslationService translationService, GeoIPLocationService geoIPLocationService) {
        super(translationService, geoIPLocationService);
    }
}
