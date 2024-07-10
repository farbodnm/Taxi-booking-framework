package com.taxi.user.service;

import com.taxi.user.dto.ExtendedUserSigninDTO;
import com.taxi.user.dto.RecaptchaResponse;
import com.taxi.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@Qualifier("AuthService")
public class ExtendedAuthServiceImpl implements ExtendedAuthService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private RecaptchaService recaptchaService;

    @Override
    public ExtendedUserSigninDTO signIn(ExtendedUserSigninDTO dto) {
        RecaptchaResponse response = recaptchaService.validateToken(dto.getCaptcha());
        if ( !response.success() ) throw new BadCredentialsException("Invalid recaptcha token!");
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getUsername(),
                        dto.getPassword()
                )
        );
        var user = userRepository.findByUsername(dto.getUsername())
                .orElseThrow();
        String jwtToken = jwtService.generateToken(user);
        dto.setToken(jwtToken);
        return dto;
    }
}
