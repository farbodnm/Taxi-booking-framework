package com.taxi.framework.translation.dto;

public class AddTranslationDto {
    private Long contentId;
    private int languageTypeId;
    private String translationText;

    // Getters and setters
    public Long getContentId() { return contentId; }
    public void setContentId(Long contentId) { this.contentId = contentId; }
    public int getLanguageTypeId() { return languageTypeId; }
    public void setLanguageTypeId(int languageTypeId) { this.languageTypeId = languageTypeId; }
    public String getTranslationText() { return translationText; }
    public void setTranslationText(String translationText) { this.translationText = translationText; }
}
