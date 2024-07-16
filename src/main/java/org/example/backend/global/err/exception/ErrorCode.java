package org.example.backend.global.err.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    BAD_REQUEST(400, "bad request"),
    INTERNAL_SERVER_ERROR(500, "server error");

    private final int statusCode;
    private final String message;
}
