package com.taxi.framework.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseUserSignoutDTO {
    private Long id;
    private String role;
}
