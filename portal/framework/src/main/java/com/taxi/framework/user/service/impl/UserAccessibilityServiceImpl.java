package com.taxi.framework.user.service.impl;

import com.taxi.framework.user.dto.AccessibilitySettingsDTO;
import com.taxi.framework.user.service.UserAccessibilityService;
import org.springframework.stereotype.Service;

@Service
public class UserAccessibilityServiceImpl implements UserAccessibilityService {
    
    private final Map<Long, AccessibilitySettingsDTO> settingsMap = new HashMap<>();

    @Override
    public void saveAccessibilitySettings(AccessibilitySettingsDTO settings) {
        settingsMap.put(settings.getUserId(), settings);
    }

    @Override
    public AccessibilitySettingsDTO getAccessibilitySettings(long userId) {
        return settingsMap.get(userId);
    }
}
