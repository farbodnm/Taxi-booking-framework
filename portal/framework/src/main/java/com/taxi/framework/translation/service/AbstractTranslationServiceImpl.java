package com.taxi.framework.translation.service;

import com.taxi.framework.translation.Repository.AbstractContentRepository;
import com.taxi.framework.translation.Repository.AbstractLanguageTypeRepository;
import com.taxi.framework.translation.Repository.AbstractTranslationRepository;
import com.taxi.framework.translation.dto.*;
import com.taxi.framework.translation.model.Content;
import com.taxi.framework.translation.model.LanguageType;
import com.taxi.framework.translation.model.Translation;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;


public class AbstractTranslationServiceImpl<T extends BaseTranslationDto, Y extends BaseResponseTranslationDto> implements TranslationService<T, Y> {

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
        System.out.println(content.getSection() + " " + content.getText());
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
        for (Translation translation : list) {
            res.add(new TranslationDto(translation.getTranslationText()));
        }
        return res;
    }

    @Override
    public boolean addTranslation(@RequestBody AddTranslationDto addTranslationDto) {
        Translation translation = new Translation();
        translation.setTranslationText(addTranslationDto.getTranslationText());

        Content content = contentRepository.findById(addTranslationDto.getContentId()).orElseThrow(() -> new RuntimeException("Content not found"));
        translation.setContent(content);

        LanguageType languageType = languageTypeRepository.findById(addTranslationDto.getLanguageTypeId()).orElseThrow(() -> new RuntimeException("LanguageType not found"));
        translation.setLanguageType(languageType);

        translationRepository.save(translation);
        return true;
    }

    @Override
    public TranslationDto findByContentIdAndLanguageTypeLanguage(Long contentId, String language) {
        Translation translation = translationRepository.findByContentIdAndLanguageTypeLanguage(contentId, language);

        return new TranslationDto(translation.getTranslationText());
    }
}




















