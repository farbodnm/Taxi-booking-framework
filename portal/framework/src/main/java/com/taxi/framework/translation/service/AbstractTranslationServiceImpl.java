package com.taxi.framework.translation.service;

import com.taxi.framework.translation.Repository.AbstractLanguageTypeRepository;
import com.taxi.framework.translation.dto.BaseResponseTranslationDto;
import com.taxi.framework.translation.dto.BaseTranslationDto;
import com.taxi.framework.translation.model.LanguageType;

import java.util.ArrayList;
import java.util.List;


public class AbstractTranslationServiceImpl <T extends BaseTranslationDto, Y extends BaseResponseTranslationDto> implements TranslationService<T, Y> {

    private final AbstractLanguageTypeRepository languageTypeRepository;

    public AbstractTranslationServiceImpl(AbstractLanguageTypeRepository languageTypeRepository) {
        this.languageTypeRepository = languageTypeRepository;
    }

    public List<LanguageType> getAllLanguageTypes(){
        List<LanguageType> result = new ArrayList<>();

        result = languageTypeRepository.findAll();
        return  result;
    }
}
