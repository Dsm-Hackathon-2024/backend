package org.example.backend.domain.user.presentation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.backend.domain.user.presentation.dto.request.LoginRequest;
import org.example.backend.domain.user.presentation.dto.request.SignupRequest;
import org.example.backend.domain.user.presentation.dto.response.RankUserPointResponse;
import org.example.backend.domain.user.presentation.dto.response.TokenResponse;
import org.example.backend.domain.user.presentation.dto.response.UserInfoResponse;
import org.example.backend.domain.user.presentation.dto.response.UserInvestResponse;
import org.example.backend.domain.user.service.RankUserPointService;
import org.example.backend.domain.user.service.UserLoginService;
import org.example.backend.domain.user.service.UserInfoService;
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
    private final UserInfoService userInfoService;
    private final UserInvestService userInvestService;
    private final RankUserPointService rankUserPointService;

    @PostMapping("/auth/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public TokenResponse signup(@RequestBody @Valid SignupRequest request) {
        return signupService.execute(request);
    }

    @PostMapping("/auth/login")
    public TokenResponse login(@RequestBody @Valid LoginRequest request) {
        return loginService.execute(request);
    }

    @GetMapping("/mypage/userinfo")
    public UserInfoResponse getUserPoints() {
        return userInfoService.execute();
    }

    @GetMapping("/mypage/invest")
    public List<UserInvestResponse> getUserInvests() {
        return userInvestService.execute();
    }

    @GetMapping("/rank")
    public RankUserPointResponse getRankUserPoints() {
        return rankUserPointService.execute();
    }
}
