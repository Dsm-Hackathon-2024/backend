package org.example.backend.global.security.auth;

import lombok.RequiredArgsConstructor;
import org.example.backend.domain.user.domain.User;
import org.example.backend.domain.user.facade.UserFacade;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserFacade userFacade;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userFacade.findByUsername(username);

        return new CustomUserDetails(user);
    }
}
