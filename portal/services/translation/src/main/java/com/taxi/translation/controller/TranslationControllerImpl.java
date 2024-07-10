package com.taxi.translation.controller;

import com.taxi.framework.translation.controller.AbstractTranslationController;
import com.taxi.framework.translation.dto.BaseResponseTranslationDto;
import com.taxi.framework.translation.dto.BaseTranslationDto;
import com.taxi.framework.translation.service.GeoIPLocationService;
import com.taxi.translation.service.TranslateFacadeServiceImpl;
import com.taxi.translation.service.TranslationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/translation")
@RestController
public class TranslationControllerImpl extends AbstractTranslationController<BaseTranslationDto, BaseResponseTranslationDto> {

    public TranslationControllerImpl(TranslationServiceImpl translationService, GeoIPLocationService geoIPLocationService,
                                     TranslateFacadeServiceImpl translateFacadeService) {
        super(translationService, geoIPLocationService, translateFacadeService);
    }
}
