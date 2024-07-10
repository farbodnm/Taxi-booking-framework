package com.taxi.framework.translation.controller;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.taxi.framework.translation.dto.*;
import com.taxi.framework.translation.model.LanguageType;
import com.taxi.framework.translation.service.GeoIPLocationService;
import com.taxi.framework.translation.service.TranslationFacadeService;
import com.taxi.framework.translation.service.TranslationService;
import jakarta.servlet.http.HttpServletRequest;
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
    public ResponseEntity<InsertCommandDto> addContent(@RequestBody AddContentDto addContentDto) {
        Boolean result = translationService.addContent(addContentDto);
        return ResponseEntity.ok(new InsertCommandDto(result));
    }

    @PostMapping("/languageType")
    public ResponseEntity<InsertCommandDto> addLanguageType(@RequestBody AddLanguageTypeDto languageTypeDto) {
        Boolean result = translationService.addLanguageTypes(languageTypeDto);
        return ResponseEntity.ok(new InsertCommandDto(result));
    }

    @PostMapping()
    public ResponseEntity<InsertCommandDto> addTranslation(@RequestBody AddTranslationDto translationDto) {
        Boolean result = translationService.addTranslation(translationDto);
        return ResponseEntity.ok(new InsertCommandDto(result));
    }


    @GetMapping
    public ResponseEntity<Y> getTranslation(@RequestBody T inputDto) {
        return ResponseEntity.ok(translationService.getTranslationsByContentIdAndLanguageTypeId(inputDto));
    }

    @GetMapping("/languageTypes")
    public ResponseEntity<List<LanguageTypeDto>> getLnguageTypes() throws IOException, GeoIp2Exception {
        return ResponseEntity.ok(translationService.getAllLanguageTypes());
    }

    @GetMapping("/v2")
    public ResponseEntity<Y> getTranslationBylanguage(@RequestBody T inputDto) {
        return ResponseEntity.ok(translationService.getTranslationByContentIdAndLanguageTypeLanguage(inputDto.getContentId(),
                inputDto.getLanguageType()));
    }

    @GetMapping("/ip")
    public ResponseEntity<Y> getTranslationByIP(@RequestBody T inputDto, HttpServletRequest request)
            throws IOException, GeoIp2Exception {
        return ResponseEntity.ok(translationFacadeService.GetTranslationContentByIP(inputDto, request.getRemoteAddr()));
    }

    @GetMapping("/section/ip")
    public ResponseEntity<List<Y>> getSectionTranslationByIP(@RequestBody T inputDto, HttpServletRequest request)
            throws IOException, GeoIp2Exception {
        return ResponseEntity.ok(translationFacadeService.GetSectionTranslationContentByIP(inputDto, request.getRemoteAddr()));
    }
}








