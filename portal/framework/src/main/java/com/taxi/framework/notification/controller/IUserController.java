package com.taxi.framework.notification.controller;

import com.taxi.framework.notification.controller.dto.UserResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.taxi.framework.notification.controller.dto.UserCreateDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public interface IUserController {

    ResponseEntity<?> createUser(@RequestBody @Valid UserCreateDTO dto);

    ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id);
}
