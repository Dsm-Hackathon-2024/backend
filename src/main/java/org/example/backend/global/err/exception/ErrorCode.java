package org.example.backend.global.err.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    USER_ALREADY_EXISTS(409, "User Already Exists"),
    EXPIRED_TOKEN(401, "expired token"),
    INVALID_TOKEN(401, "invalid token"),
    PASSWORD_MISMATCH(401, "password mismatch"),
    USER_NOT_FOUND(404, "User Not Found"),
    BAD_REQUEST(400, "bad request"),
    INTERNAL_SERVER_ERROR(500, "server error");

    private final int statusCode;
    private final String message;
}
