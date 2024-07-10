package com.taxi.framework.translation.dto;


public class AddLanguageTypeDto {

    private String language;
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public AddLanguageTypeDto(){

    }
    public AddLanguageTypeDto(String language) {
        this.language = language;
    }
}
