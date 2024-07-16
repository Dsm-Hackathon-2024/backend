package org.example.backend.global.err.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BackendException extends RuntimeException {

    private final ErrorCode errorCode;
}
