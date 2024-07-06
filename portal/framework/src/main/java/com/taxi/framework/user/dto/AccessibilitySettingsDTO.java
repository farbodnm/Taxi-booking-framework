package com.taxi.framework.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AccessibilitySettingsDTO {
    private long userId;
    private boolean screenReaderEnabled;
    private boolean voiceCommandEnabled;
    private float textZoomLevel;
}
