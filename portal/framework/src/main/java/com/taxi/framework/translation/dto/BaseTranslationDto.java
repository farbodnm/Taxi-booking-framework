package com.taxi.framework.translation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseTranslationDto {

    private Long contentId;
    private String section;
    private long languageTypeId;
    private String languageType;

    public BaseTranslationDto() {
    }

    public BaseTranslationDto(Long contentId, String section, long languageTypeId, String languageType) {
        this.contentId = contentId;
        this.section = section;
        this.languageTypeId = languageTypeId;
        this.languageType = languageType;
    }
}
