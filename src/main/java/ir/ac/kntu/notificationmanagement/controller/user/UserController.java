package ir.ac.kntu.notificationmanagement.controller.user;

import ir.ac.kntu.notificationmanagement.controller.user.dto.UserCreateDTO;
import ir.ac.kntu.notificationmanagement.controller.user.dto.UserResponseDTO;
import ir.ac.kntu.notificationmanagement.model.User;
import ir.ac.kntu.notificationmanagement.service.UserService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody @Valid UserCreateDTO dto) {
        User user = userService.createUser(dto);
        return ResponseEntity.ok(user);
    }

    @GetMapping("{id}")
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
