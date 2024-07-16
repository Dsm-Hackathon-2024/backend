package org.example.backend.domain.user.exception;

import org.example.backend.global.err.exception.BackendException;
import org.example.backend.global.err.exception.ErrorCode;

public class UserNotFoundException extends BackendException {

    public static final BackendException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}