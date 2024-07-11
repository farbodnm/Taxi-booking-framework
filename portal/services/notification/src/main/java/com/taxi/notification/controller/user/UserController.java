package com.taxi.notification.controller.user;

import com.taxi.framework.notification.controller.IUserController;
import com.taxi.framework.notification.controller.dto.UserCreateDTO;
import com.taxi.framework.notification.controller.dto.UserResponseDTO;
import com.taxi.framework.notification.model.User;
import com.taxi.notification.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("users")
public class UserController implements IUserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @Override
    public ResponseEntity<?> createUser(@RequestBody @Valid UserCreateDTO dto) {
        User user = userService.createUser(dto);
        return ResponseEntity.ok(user);
    }

    @GetMapping("{id}")
    @Override
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(convertUserToUserResponseDTO(user));
    }

    private UserResponseDTO convertUserToUserResponseDTO(User user) {
        return UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .pushToken(user.getPushToken())
                .build();
    }
}
