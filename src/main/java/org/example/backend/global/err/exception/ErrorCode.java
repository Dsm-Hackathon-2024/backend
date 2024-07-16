package org.example.backend.global.err.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    //400
    BAD_REQUEST(400, "bad request"),
    FEIGN_BAD_REQUEST(400, "Feign Bad Request"),

    //401
    FEIGN_UNAUTHORIZED(401, "Feign Unauthorized"),
    EXPIRED_TOKEN(401, "expired token"),
    INVALID_TOKEN(401, "invalid token"),
    PASSWORD_MISMATCH(401, "password mismatch"),

    //404
    USER_NOT_FOUND(404, "User Not Found"),

    //403
    FEIGN_FORBIDDEN(403, "Feign Forbidden"),

    //409
    USER_ALREADY_EXISTS(409, "User Already Exists"),

    //419
    FEIGN_TOKEN_EXPIRED(419, "Feign Token Expired"),

    //500
    INTERNAL_SERVER_ERROR(500, "server error");

    private final int statusCode;
    private final String message;
}
