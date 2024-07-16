package org.example.backend.domain.user.service;

import lombok.RequiredArgsConstructor;

import org.example.backend.domain.user.domain.User;
import org.example.backend.domain.user.facade.UserFacade;
import org.example.backend.domain.user.presentation.dto.request.LoginRequest;
import org.example.backend.domain.user.presentation.dto.response.TokenResponse;
import org.example.backend.domain.user.exception.PasswordNotValidException;
import org.example.backend.global.security.jwt.JwtTokenProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserLoginService {

    private final JwtTokenProvider tokenProvider;

    private final PasswordEncoder passwordEncoder;

    private final UserFacade userFacade;

    public TokenResponse execute(LoginRequest request) {
        User user = userFacade.findByName(request.getName());

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordNotValidException.EXCEPTION;
        }

        return tokenProvider.receiveToken(request.getName());
    }
}