package com.taxi.framework.translation.service;

import com.taxi.framework.translation.dto.AddContentDto;
import com.taxi.framework.translation.dto.AddLanguageTypeDto;
import com.taxi.framework.translation.dto.BaseResponseTranslationDto;
import com.taxi.framework.translation.dto.BaseTranslationDto;
import com.taxi.framework.translation.model.LanguageType;

import java.util.List;

public interface TranslationService <T extends BaseTranslationDto, Y extends BaseResponseTranslationDto> {
    List<LanguageType> getAllLanguageTypes();
    boolean addContent(AddContentDto addContentDto);
    boolean addLanguageTypes(AddLanguageTypeDto languageTypeDto);
}
