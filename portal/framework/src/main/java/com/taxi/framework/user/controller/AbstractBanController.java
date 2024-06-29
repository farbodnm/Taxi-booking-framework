package com.taxi.framework.user.controller;

import com.taxi.framework.dispatch.dto.BaseDriverDTO;
import com.taxi.framework.user.service.BanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class AbstractBanController<T extends BaseDriverDTO> {

    protected final BanService<T> banService;


    protected AbstractBanController(BanService<T> service) {
        this.banService = service;
    }


    @PostMapping("/banDriver")
    public ResponseEntity<T> banDriver(@RequestBody T dto) {
        return ResponseEntity.ok(banService.banDriver(dto));
    }

}
