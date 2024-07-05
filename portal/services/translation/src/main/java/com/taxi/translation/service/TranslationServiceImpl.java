package com.taxi.translation.service;

import com.taxi.framework.translation.Repository.AbstractContentRepository;
import com.taxi.framework.translation.dto.BaseResponseTranslationDto;
import com.taxi.framework.translation.dto.BaseTranslationDto;
import com.taxi.framework.translation.service.AbstractTranslationServiceImpl;
import com.taxi.translation.repository.ContentRepositoryImpl;
import com.taxi.translation.repository.LanguageTypeRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranslationServiceImpl extends AbstractTranslationServiceImpl<BaseTranslationDto, BaseResponseTranslationDto> {


    @Autowired
    private LanguageTypeRepositoryImpl languageTypeRepository;
    @Autowired
    private ContentRepositoryImpl contentRepository;

    public TranslationServiceImpl(LanguageTypeRepositoryImpl languageTypeRepository,
                                  ContentRepositoryImpl contentRepository){
        super(languageTypeRepository, contentRepository);
    }
}
