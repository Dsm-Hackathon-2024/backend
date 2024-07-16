package org.example.backend.domain.user.facade;

import org.example.backend.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.example.backend.domain.user.domain.repository.UserRepository;
import org.example.backend.domain.user.exception.UserNotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;

    public User getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByName(username).orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public User findByUsername(String username) {
        return userRepository.findByName(username).orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}