package com.taxi.user.service;

import com.taxi.framework.user.dao.PassengerDao;
import com.taxi.framework.user.dao.UserDao;
import com.taxi.framework.user.dto.BaseUserSignoutDTO;
import com.taxi.framework.user.dto.BaseUserSignupDTO;
import com.taxi.framework.user.service.SignoutService;
import com.taxi.framework.user.service.SignupService;
import com.taxi.user.repository.DriverRepository;
import com.taxi.user.repository.PassengerRepository;
import com.taxi.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.beans.Transient;

@Service
@Qualifier("SignoutService")
public class SignoutServiceImpl implements SignoutService<BaseUserSignoutDTO> {

    @Autowired
    private PassengerRepository passengerRepository;
    @Autowired
    private DriverRepository driverRepository;

    @Override
    @Transactional
    public BaseUserSignoutDTO signOut(BaseUserSignoutDTO dto) {
        UserRepository<? extends UserDao> userRepository = getUserRepository(dto.getRole());
        userRepository.updateSignInStatusByID(dto.getId(), "signed out");
        return dto;
    }

    private UserRepository<? extends UserDao> getUserRepository(String role) {
        if ("driver".equals(role)) {
            return driverRepository;
        } else if ("passenger".equals(role)) {
            return passengerRepository;
        }
        throw new IllegalArgumentException("Unknown role: " + role);
    }

}
