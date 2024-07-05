package com.taxi.framework.translation.controller;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.taxi.framework.translation.dto.*;
import com.taxi.framework.translation.model.Content;
import com.taxi.framework.translation.model.LanguageType;
import com.taxi.framework.translation.service.GeoIPLocationService;
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

    public AbstractTranslationController(TranslationService<T, Y> translationService, GeoIPLocationService geoIPLocationService) {
        this.translationService = translationService;
        this.geoIPLocationService = geoIPLocationService;
    }

    @GetMapping("/test")
    public ResponseEntity<List<LanguageType>> refresh() throws IOException, GeoIp2Exception {
        return ResponseEntity.ok(translationService.getAllLanguageTypes());
    }
    @PostMapping("/content")
    public ResponseEntity<Boolean> addContent(@RequestBody AddContentDto addContentDto) {
        return ResponseEntity.ok(translationService.addContent(addContentDto));
    }

    @PostMapping("/language")
    public ResponseEntity<Boolean> addLanguageType(@RequestBody AddLanguageTypeDto languageTypeDto) {
        return ResponseEntity.ok(translationService.addLanguageTypes(languageTypeDto));
    }

    @GetMapping("/gettranslation")
    public ResponseEntity<List<TranslationDto>> getTranslation(@RequestParam Long contentId,
                                                               @RequestParam Long languageTypeId) {
        return ResponseEntity.ok(translationService.findByContentIdAndLanguageTypeId(contentId,
                languageTypeId));
    }
}








