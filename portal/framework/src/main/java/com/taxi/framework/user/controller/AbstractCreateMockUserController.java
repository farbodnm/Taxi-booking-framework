package com.taxi.framework.user.controller;

import com.taxi.framework.dispatch.dto.BaseDriverDTO;
import com.taxi.framework.user.dto.BaseUserSignupDTO;
import com.taxi.framework.user.service.BanService;
import com.taxi.framework.user.service.CreateMockUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class AbstractCreateMockUserController<T extends BaseUserSignupDTO> {

    protected final CreateMockUserService<T> createMockUserService;


    protected AbstractCreateMockUserController(CreateMockUserService<T> service) {
        this.createMockUserService = service;
    }


    @PostMapping("/createMockUser")
    public ResponseEntity<T> createMockUser(@RequestBody T dto) {
        return ResponseEntity.ok(createMockUserService.createMockUser(dto));
    }

}
