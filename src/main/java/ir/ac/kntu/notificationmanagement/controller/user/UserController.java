package ir.ac.kntu.notificationmanagement.controller.user;

import ir.ac.kntu.notificationmanagement.controller.user.dto.UserCreateDTO;
import ir.ac.kntu.notificationmanagement.service.UserService;
import jakarta.validation.Valid;
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
        userService.createUser(dto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
