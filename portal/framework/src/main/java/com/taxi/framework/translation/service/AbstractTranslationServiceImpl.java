package com.taxi.framework.translation.service;

import com.taxi.framework.translation.Repository.AbstractContentRepository;
import com.taxi.framework.translation.Repository.AbstractLanguageTypeRepository;
import com.taxi.framework.translation.dto.AddContentDto;
import com.taxi.framework.translation.dto.BaseResponseTranslationDto;
import com.taxi.framework.translation.dto.BaseTranslationDto;
import com.taxi.framework.translation.dto.AddLanguageTypeDto;
import com.taxi.framework.translation.model.Content;
import com.taxi.framework.translation.model.LanguageType;

import java.util.ArrayList;
import java.util.List;


public class AbstractTranslationServiceImpl <T extends BaseTranslationDto, Y extends BaseResponseTranslationDto> implements TranslationService<T, Y> {

    private final AbstractLanguageTypeRepository languageTypeRepository;
    private final AbstractContentRepository contentRepository;

    public AbstractTranslationServiceImpl(AbstractLanguageTypeRepository languageTypeRepository, AbstractContentRepository contentRepository) {
        this.languageTypeRepository = languageTypeRepository;
        this.contentRepository = contentRepository;
    }

    public List<LanguageType> getAllLanguageTypes() {
        List<LanguageType> result = new ArrayList<>();

        result = languageTypeRepository.findAll();
        return result;
    }

    public boolean addContent(AddContentDto addContentDto) {
        Content content = new Content();
        content.setSection(addContentDto.getSection());
        content.setText(addContentDto.getText());
        System.out.println(content.getSection()+" "+ content.getText());
        contentRepository.save(content);
        return true;
    }

    public boolean addLanguageTypes(AddLanguageTypeDto languageTypeDto) {

        LanguageType languageType = new LanguageType();

        languageType.setLanguage(languageTypeDto.getLanguage());

        languageTypeRepository.save(languageType);

        return true;
    }
}




















