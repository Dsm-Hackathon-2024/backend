package org.example.backend.domain.user.presentation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.backend.domain.user.presentation.dto.request.LoginRequest;
import org.example.backend.domain.user.presentation.dto.request.PointRequest;
import org.example.backend.domain.user.presentation.dto.request.SignupRequest;
import org.example.backend.domain.user.presentation.dto.response.RankUserPointResponse;
import org.example.backend.domain.user.presentation.dto.response.TokenResponse;
import org.example.backend.domain.user.presentation.dto.response.UserInfoResponse;
import org.example.backend.domain.user.presentation.dto.response.UserInvestResponse;
import org.example.backend.domain.user.service.*;
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
    private final AddUserPointService addUserPointService;

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

    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addUserPoints(@RequestParam("point") Integer point) {
        addUserPointService.execute(point);
    }
}
