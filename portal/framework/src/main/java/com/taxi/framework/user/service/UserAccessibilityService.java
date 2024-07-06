package com.taxi.framework.user.service;

import com.taxi.framework.user.dto.AccessibilitySettingsDTO;

public interface UserAccessibilityService {
    void saveAccessibilitySettings(AccessibilitySettingsDTO settings);
    AccessibilitySettingsDTO getAccessibilitySettings(long userId);
}
