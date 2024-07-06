package com.taxi.framework.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseUserSignupDTO {
    private long userId;
    private String username;
    private String password;
    private AccessibilitySettingsDTO accessibilitySettings;
}