package com.taxi.framework.translation.service;

import com.taxi.framework.translation.dto.*;
import com.taxi.framework.translation.model.LanguageType;

import java.util.List;

public interface TranslationService <T extends BaseTranslationDto, Y extends BaseResponseTranslationDto> {
    boolean addContent(AddContentDto addContentDto);
    boolean addLanguageTypes(AddLanguageTypeDto languageTypeDto);
    boolean addTranslation(AddTranslationDto addTranslationDto);
    List<LanguageTypeDto> getAllLanguageTypes();
    Y getTranslationsByContentIdAndLanguageTypeId(T dto);
    Y getTranslationByContentIdAndLanguageTypeLanguage(Long contentId, String language);
    List<Y> getSectionTranslationContentIdAndLanguageTypeLanguage(String section, String language);


}
