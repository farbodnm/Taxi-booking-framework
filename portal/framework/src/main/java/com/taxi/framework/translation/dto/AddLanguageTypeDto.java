package com.taxi.framework.translation.dto;

import com.taxi.framework.translation.model.Translation;


import java.util.Set;

public class AddLanguageTypeDto {

    private String language;

    public AddLanguageTypeDto(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
