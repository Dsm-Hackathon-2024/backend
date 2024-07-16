package org.example.backend.global.err;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.example.backend.global.err.exception.ErrorCode;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
public class ErrorResponse {

    private String message;
    private LocalDateTime timestamp;

    public static ErrorResponse of(ErrorCode errorCode) {
        return ErrorResponse.builder().message(errorCode.getMessage()).timestamp(LocalDateTime.now()).build();
    }

    public static ErrorResponse of(String message) {
        return ErrorResponse.builder().message(message).timestamp(LocalDateTime.now()).build();
    }
}
