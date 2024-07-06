package com.taxi.framework.user.controller;

import com.taxi.framework.user.dto.BaseUserSignupDTO;
import com.taxi.framework.user.dto.AccessibilitySettingsDTO;
import com.taxi.framework.user.service.SignupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class AbstractSignupController<T extends BaseUserSignupDTO> {

    protected final SignupService<T> signupService;

    protected AbstractSignupController(SignupService<T> signupService) {
        this.signupService = signupService;
    }

    @PostMapping("/signup")
    public ResponseEntity<T> signUp(@RequestBody T dto) {
        T signedUpUser = signupService.signUp(dto);
        updateAccessibilitySettings(signedUpUser.getAccessibilitySettings());
        return ResponseEntity.ok(signedUpUser);
    }

    private void updateAccessibilitySettings(AccessibilitySettingsDTO settings) {
        if (settings != null) {
            if (settings.isScreenReaderEnabled()) {
                // Apply screen reader specific logic
            }
            if (settings.isVoiceCommandEnabled()) {
                // Apply voice command specific logic
            }
        }
    }
}
