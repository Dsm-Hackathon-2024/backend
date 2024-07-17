package org.example.backend.domain.user.service;

import lombok.RequiredArgsConstructor;

import org.example.backend.domain.user.domain.User;
import org.example.backend.domain.user.facade.UserFacade;
import org.example.backend.domain.user.presentation.dto.response.UserPointResponse;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserPointService {

    private final UserFacade userFacade;

    public UserPointResponse execute() {
        User user = userFacade.getCurrentUser();

        return UserPointResponse.builder()
                .points(user.getPoint())
                .build();
    }
}