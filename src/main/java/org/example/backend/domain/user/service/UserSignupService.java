package org.example.backend.domain.user.service;

import lombok.RequiredArgsConstructor;

import org.example.backend.domain.user.domain.User;
import org.example.backend.domain.user.domain.repository.UserRepository;
import org.example.backend.domain.user.presentation.dto.request.SignupRequest;
import org.example.backend.domain.user.presentation.dto.response.TokenResponse;
import org.example.backend.domain.user.exception.UserAlreadyExistsException;
import org.example.backend.global.security.jwt.JwtTokenProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class UserSignupService {

    private final JwtTokenProvider tokenProvider;

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    @Transactional
    public TokenResponse execute(SignupRequest request) {
        String name = request.getName();
        String password = passwordEncoder.encode(request.getPassword());

        if (userRepository.existsByName(name)) {
            throw UserAlreadyExistsException.EXCEPTION;
        }

        User user = userRepository.save(User.builder()
                .name(name)
                .password(password)
                .point(0L)
                .build());

        return tokenProvider.receiveToken(name);
    }
}