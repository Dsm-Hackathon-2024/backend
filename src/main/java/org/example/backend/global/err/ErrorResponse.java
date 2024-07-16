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
    private Integer status;

    public static ErrorResponse of(ErrorCode errorCode) {
        return ErrorResponse.builder().message(errorCode.getMessage()).status(errorCode.getStatusCode()).build();
    }

    public static ErrorResponse of(String message,int status) {
        return ErrorResponse.builder().message(message).status(status).build();
    }
}
