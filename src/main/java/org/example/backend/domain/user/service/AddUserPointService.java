package org.example.backend.domain.user.service;

import lombok.RequiredArgsConstructor;

import org.example.backend.domain.user.domain.User;
import org.example.backend.domain.user.facade.UserFacade;
import org.example.backend.domain.user.presentation.dto.request.PointRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AddUserPointService {

    private final UserFacade userFacade;

    @Transactional
    public void execute(Integer point) {
        User user = userFacade.getCurrentUser();
        user.setPoint(user.getPoint() + point);
    }
}