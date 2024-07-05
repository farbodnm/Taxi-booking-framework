package com.taxi.framework.translation.dto;

public class BaseTranslationDto {
    private Long contentId;

    public BaseTranslationDto() {
    }

    public BaseTranslationDto(Long contentId) {
        this.contentId = contentId;
    }
    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }
}
