package com.taxi.framework.translation.dto;

public class TranslationDto {
    private String text;


    public TranslationDto() {
    }

    public TranslationDto(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
