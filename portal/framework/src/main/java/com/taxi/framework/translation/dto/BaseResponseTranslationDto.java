package com.taxi.framework.translation.dto;

public class BaseResponseTranslationDto {

    private String translationText;
    private long contentId;

    public BaseResponseTranslationDto() {
    }

    public BaseResponseTranslationDto(String translationText, long contentId) {
        this.translationText = translationText;
        this.contentId = contentId;
    }

    public String getTranslationText() {
        return translationText;
    }

    public void setTranslationText(String translationText) {
        this.translationText = translationText;
    }

    public long getContentId() {
        return contentId;
    }

    public void setContentId(long contentId) {
        this.contentId = contentId;
    }
}
