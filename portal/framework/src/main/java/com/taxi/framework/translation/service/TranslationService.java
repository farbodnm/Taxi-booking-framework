package com.taxi.framework.translation.service;

import com.taxi.framework.translation.dto.*;
import com.taxi.framework.translation.model.LanguageType;
import com.taxi.framework.translation.model.Translation;

import java.util.List;

public interface TranslationService <T extends BaseTranslationDto, Y extends BaseResponseTranslationDto> {
    List<LanguageType> getAllLanguageTypes();
    boolean addContent(AddContentDto addContentDto);
    boolean addLanguageTypes(AddLanguageTypeDto languageTypeDto);
    List<TranslationDto> findByContentIdAndLanguageTypeId(Long contentId, Long languageTypeId);
    boolean addTranslation(AddTranslationDto addTranslationDto);
    Y findByContentIdAndLanguageTypeLanguage(Long contentId, String language);

    List<Y> findByPageContentIdAndLanguageTypeLanguage(String section, String language);


}
