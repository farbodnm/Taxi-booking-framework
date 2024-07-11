package com.taxi.user.service;

import com.taxi.framework.user.dao.DriverDao;
import com.taxi.framework.user.dao.PassengerDao;
import com.taxi.framework.user.dao.UserDao;
import com.taxi.user.dto.ExtendedUserSigninDTO;
import com.taxi.user.repository.DriverRepository;
import com.taxi.user.repository.PassengerRepository;
import com.taxi.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("AuthService")
public class ExtendedAuthServiceImpl implements ExtendedAuthService {
    private static final Logger logger = LoggerFactory.getLogger(ExtendedAuthServiceImpl.class);

    @Autowired
    private PassengerRepository passengerRepository;
    @Autowired
    private DriverRepository driverRepository;

    @Override
    @Transactional
    public ExtendedUserSigninDTO signIn(ExtendedUserSigninDTO dto) {
        UserRepository<? extends UserDao> userRepository = getUserRepository(dto.getRole());
        userRepository.updateSignInStatusByUsername(dto.getUsername(), dto.getEmail(), dto.getPhone(), "signed in");
        return dto;
    }

    public boolean isAuthorized(ExtendedUserSigninDTO dto) {
        UserRepository<? extends UserDao> userRepository = getUserRepository(dto.getRole());
        UserDao user = userRepository.findFirstByUsernameOrEmailOrPhone(dto.getUsername(), dto.getEmail(), dto.getPhone());

        if (user == null) {
            logger.info("User not found with username, email, or phone: " + dto.getUsername() + ", " + dto.getEmail() + ", " + dto.getPhone());
            return false;
        }

        logger.info("Found user with id: " + user.getId());
        logger.info("User: " + user);
        return user.getPassword().equals(dto.getPassword());
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
