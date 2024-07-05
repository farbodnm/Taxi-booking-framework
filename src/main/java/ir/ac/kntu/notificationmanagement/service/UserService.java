package ir.ac.kntu.notificationmanagement.service;

import ir.ac.kntu.notificationmanagement.controller.user.dto.UserCreateDTO;
import ir.ac.kntu.notificationmanagement.model.User;
import ir.ac.kntu.notificationmanagement.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(UserCreateDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setPushToken(dto.getPushToken());
        userRepository.save(user);
    }
}
