package org.example.backend.domain.user.service;

import lombok.RequiredArgsConstructor;

import org.example.backend.domain.user.domain.User;
import org.example.backend.domain.user.facade.UserFacade;
import org.example.backend.domain.user.presentation.dto.response.UserInfoResponse;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserInfoService {

    private final UserFacade userFacade;

    public UserInfoResponse execute() {
        User user = userFacade.getCurrentUser();

        return UserInfoResponse.builder()
                .name(user.getName())
                .points(user.getPoint())
                .build();
    }
}