package org.example.backend.domain.user.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PointRequest {

    @NotBlank(message = "Null 또는 공백 또는 띄어쓰기를 허용하지 않습니다.")
    private Long point;
}