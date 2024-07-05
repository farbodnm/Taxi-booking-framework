package com.taxi.framework.translation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddContentDto {
    private String text;
    private String section;

    public AddContentDto(String text, String section) {
        this.text = text;
        this.section = section;
    }
}
