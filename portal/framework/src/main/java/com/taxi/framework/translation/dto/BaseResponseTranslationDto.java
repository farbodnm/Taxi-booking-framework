package com.taxi.framework.translation.dto;

public class BaseResponseTranslationDto {

    private String translationText;

    public BaseResponseTranslationDto() {
    }

    public BaseResponseTranslationDto(String translationText) {
        this.translationText = translationText;
    }

    public String getTranslationText() {
        return translationText;
    }

    public void setTranslationText(String translationText) {
        this.translationText = translationText;
    }
}
