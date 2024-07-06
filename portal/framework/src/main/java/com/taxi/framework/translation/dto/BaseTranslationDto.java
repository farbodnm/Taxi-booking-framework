package com.taxi.framework.translation.dto;

public class BaseTranslationDto {
    private Long contentId;
    private String section;

    public BaseTranslationDto() {
    }

    public BaseTranslationDto(Long contentId, String section)
    {
        this.contentId = contentId;
        this.section = section;
    }
    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
