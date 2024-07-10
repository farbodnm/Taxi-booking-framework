package com.taxi.user.service;

import com.taxi.framework.user.dao.UserDao;
import com.taxi.framework.user.dto.BaseUserSignupDTO;
import com.taxi.framework.user.service.SignupService;
import com.taxi.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Qualifier("SignupService")
public class SignupServiceImpl implements SignupService<BaseUserSignupDTO> {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;

    @Override
    public BaseUserSignupDTO signUp(BaseUserSignupDTO dto) {
        if ( userRepository.findByUsername(dto.getUsername()).isPresent() )
            throw new RuntimeException("Username already exists!");
        var user = UserDao.builder()
                .username(dto.getUsername())
                .password(passwordEncoder.encode(dto.getPassword()))
                .dateOfBirth(dto.getDateOfBirth())
                .build();
        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);
        dto.setToken(jwtToken);
        return dto;
    }
}
