package org.example.backend.domain.user.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginRequest {

    @NotBlank(message = "Null 또는 공백 또는 띄어쓰기를 허용하지 않습니다.")
    private String name;

    @NotBlank(message = "password는 Null 또는 공백 또는 띄어쓰기를 허용하지 않습니다.")
    @Pattern(
            regexp =
                    "(?=.*[a-z])(?=.*[0-9])(?=.*[!#$%&'()*+,./:;<=>?@＼^_`{|}~])[a-zA-Z0-9!#$%&'()*+,./:;<=>?@＼^_`{|}~]{8,32}$",
            message = "password는 소문자, 숫자, 특수문자가 포함되어야 합니다.")
    private String password;
}