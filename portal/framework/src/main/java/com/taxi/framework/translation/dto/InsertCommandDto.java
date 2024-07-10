package com.taxi.framework.translation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InsertCommandDto {
    private Boolean Successed;

    public InsertCommandDto(Boolean successed) {
        Successed = successed;
    }
}
