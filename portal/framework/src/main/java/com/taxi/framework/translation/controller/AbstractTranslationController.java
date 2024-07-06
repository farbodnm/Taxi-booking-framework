package com.taxi.framework.translation.controller;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.taxi.framework.translation.dto.*;
import com.taxi.framework.translation.model.LanguageType;
import com.taxi.framework.translation.service.GeoIPLocationService;
import com.taxi.framework.translation.service.TranslationFacadeService;
import com.taxi.framework.translation.service.TranslationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

public class AbstractTranslationController <T extends BaseTranslationDto, Y extends BaseResponseTranslationDto>{

    protected final TranslationService<T,Y> translationService;
    protected final GeoIPLocationService geoIPLocationService;

    protected final TranslationFacadeService<T,Y> translationFacadeService;

    public AbstractTranslationController(TranslationService<T, Y> translationService, GeoIPLocationService geoIPLocationService, TranslationFacadeService<T, Y> translationFacadeService) {
        this.translationService = translationService;
        this.geoIPLocationService = geoIPLocationService;
        this.translationFacadeService = translationFacadeService;
    }

    @PostMapping("/content")
    public ResponseEntity<Boolean> addContent(@RequestBody AddContentDto addContentDto) {
        return ResponseEntity.ok(translationService.addContent(addContentDto));
    }

    @PostMapping("/languageType")
    public ResponseEntity<Boolean> addLanguageType(@RequestBody AddLanguageTypeDto languageTypeDto) {
        return ResponseEntity.ok(translationService.addLanguageTypes(languageTypeDto));
    }

    @PostMapping()
    public ResponseEntity<Boolean> addTranslation(@RequestBody AddTranslationDto translationDto) {
        return ResponseEntity.ok(translationService.addTranslation(translationDto));
    }


    @GetMapping
    public ResponseEntity<Y> getTranslation(@RequestBody T inputDto) {
        return ResponseEntity.ok(translationService.getTranslationsByContentIdAndLanguageTypeId(inputDto));
    }

    @GetMapping("/languageTypes")
    public ResponseEntity<List<LanguageTypeDto>> refresh() throws IOException, GeoIp2Exception {
        return ResponseEntity.ok(translationService.getAllLanguageTypes());
    }

    @GetMapping("/v2")
    public ResponseEntity<Y> getTranslationBylanguage(@RequestBody T inputDto) {
        return ResponseEntity.ok(translationService.getTranslationByContentIdAndLanguageTypeLanguage(inputDto.getContentId(),
                inputDto.getLanguageType()));
    }

    @GetMapping("/ip")
    public ResponseEntity<Y> getTranslationByIP(@RequestBody T inputDto) throws IOException, GeoIp2Exception {
        return ResponseEntity.ok(translationFacadeService.GetTranslationContentByIP(inputDto, "94.182.121.78"));
    }

    @GetMapping("/section/ip")
    public ResponseEntity<List<Y>> getSectionTranslationByIP(@RequestBody T inputDto) throws IOException, GeoIp2Exception {
        return ResponseEntity.ok(translationFacadeService.GetSectionTranslationContentByIP(inputDto, "94.182.121.78"));
    }
}








