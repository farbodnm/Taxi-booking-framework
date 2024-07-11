package com.taxi.notification.service;

import com.taxi.framework.notification.controller.dto.UserCreateDTO;
import com.taxi.framework.notification.model.User;
import com.taxi.framework.notification.service.IUserService;
import com.taxi.notification.exceptions.DuplicateValueException;
import com.taxi.notification.exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;
import com.taxi.notification.repository.UserRepository;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
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


    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }
}
