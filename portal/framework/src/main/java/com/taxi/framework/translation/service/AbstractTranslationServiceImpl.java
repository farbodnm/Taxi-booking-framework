package com.taxi.framework.translation.service;

import com.taxi.framework.translation.Repository.AbstractContentRepository;
import com.taxi.framework.translation.Repository.AbstractLanguageTypeRepository;
import com.taxi.framework.translation.Repository.AbstractTranslationRepository;
import com.taxi.framework.translation.dto.*;
import com.taxi.framework.translation.model.Content;
import com.taxi.framework.translation.model.LanguageType;
import com.taxi.framework.translation.model.Translation;

import java.util.ArrayList;
import java.util.List;


public class AbstractTranslationServiceImpl <T extends BaseTranslationDto, Y extends BaseResponseTranslationDto> implements TranslationService<T, Y> {

    private final AbstractLanguageTypeRepository languageTypeRepository;
    private final AbstractContentRepository contentRepository;
    private final AbstractTranslationRepository translationRepository;

    public AbstractTranslationServiceImpl(AbstractLanguageTypeRepository languageTypeRepository, AbstractContentRepository contentRepository, AbstractTranslationRepository languageRepository) {
        this.languageTypeRepository = languageTypeRepository;
        this.contentRepository = contentRepository;
        this.translationRepository = languageRepository;
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

    @Override
    public List<TranslationDto> findByContentIdAndLanguageTypeId(Long contentId, Long languageTypeId) {
        List<Translation> list = translationRepository.findByContentIdAndLanguageTypeId(contentId, languageTypeId);
        List<TranslationDto> res = new ArrayList<>();
        for(Translation translation : list) {
            res.add(new TranslationDto(translation.getTranslationText()));
        }

        return res;
    }
}




















