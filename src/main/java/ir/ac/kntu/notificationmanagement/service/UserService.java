package ir.ac.kntu.notificationmanagement.service;

import ir.ac.kntu.notificationmanagement.controller.user.dto.UserCreateDTO;
import ir.ac.kntu.notificationmanagement.exceptions.DuplicateValueException;
import ir.ac.kntu.notificationmanagement.exceptions.ResourceNotFoundException;
import ir.ac.kntu.notificationmanagement.model.User;
import ir.ac.kntu.notificationmanagement.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserCreateDTO dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new DuplicateValueException("Email already exists");
        }

        if (userRepository.existsByPhoneNumber(dto.getPhoneNumber())) {
            throw new DuplicateValueException("Phone Number already exists");
        }

        if (userRepository.existsByPushToken(dto.getPushToken())) {
            throw new DuplicateValueException("Push Token already exists");
        }

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setPushToken(dto.getPushToken());
        userRepository.save(user);
        return user;
    }


    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new ResourceNotFoundException("User %d not found".formatted(id));
        } else {
            return user.get();
        }
    }
}
