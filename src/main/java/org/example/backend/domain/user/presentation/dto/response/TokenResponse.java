package org.example.backend.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class TokenResponse {

    private String accessToken;

    private Date accessExpiredAt;
}
