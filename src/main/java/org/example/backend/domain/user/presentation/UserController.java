package org.example.backend.domain.user.presentation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.backend.domain.user.presentation.dto.request.LoginRequest;
import org.example.backend.domain.user.presentation.dto.request.SignupRequest;
import org.example.backend.domain.user.presentation.dto.response.TokenResponse;
import org.example.backend.domain.user.presentation.dto.response.UserPointResponse;
import org.example.backend.domain.user.presentation.dto.response.UserInvestResponse;
import org.example.backend.domain.user.service.UserLoginService;
import org.example.backend.domain.user.service.UserPointService;
import org.example.backend.domain.user.service.UserSignupService;
import org.example.backend.domain.user.service.UserInvestService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserLoginService loginService;
    private final UserSignupService signupService;
    private final UserPointService userPointService;
    private final UserInvestService userInvestService;

    @PostMapping("/auth/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public TokenResponse signup(@RequestBody @Valid SignupRequest request) {
        return signupService.execute(request);
    }

    @PostMapping("/auth/login")
    public TokenResponse login(@RequestBody @Valid LoginRequest request) {
        return loginService.execute(request);
    }

    @GetMapping("/mypage/points")
    public UserPointResponse getUserPoints() {
        return userPointService.execute();
    }

    @GetMapping("/mypage/invest")
    public List<UserInvestResponse> getUserInvests() {
        return userInvestService.execute();
    }
}
