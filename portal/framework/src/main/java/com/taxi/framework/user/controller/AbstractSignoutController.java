package com.taxi.framework.user.controller;

import com.taxi.framework.user.dto.BaseUserSignoutDTO;
import com.taxi.framework.user.dto.BaseUserSignupDTO;
import com.taxi.framework.user.service.SignoutService;
import com.taxi.framework.user.service.SignupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class AbstractSignoutController<T extends BaseUserSignoutDTO> {

    protected final SignoutService<T> signoutService;

    protected AbstractSignoutController(SignoutService<T> signoutService) {
        this.signoutService = signoutService;
    }

    @PostMapping("/signout")
    public ResponseEntity<T> signOut(@RequestBody T dto) {
        return ResponseEntity.ok(signoutService.signOut(dto));
    }
}
