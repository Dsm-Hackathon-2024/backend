package org.example.backend.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserPointResponse {

    private Long points;
}
