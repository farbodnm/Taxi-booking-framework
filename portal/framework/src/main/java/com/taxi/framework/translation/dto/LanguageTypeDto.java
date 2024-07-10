package com.taxi.framework.translation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LanguageTypeDto {
    private long id;
    private String language;

    public LanguageTypeDto() {
    }

    public LanguageTypeDto(long id, String language) {
        this.id = id;
        this.language = language;
    }
}
